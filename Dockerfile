# Base Ubuntu image
FROM ubuntu:22.04

# Set up base utilities
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    unzip \
    git \
    software-properties-common \
    gnupg \
    ca-certificates \
    lsb-release \
    openjdk-21-jdk \
    && rm -rf /var/lib/apt/lists/*

# Maven set up
RUN wget https://downloads.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz && \
    tar xzvf apache-maven-3.9.5-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.5/bin/mvn /usr/bin/mvn && \
    rm apache-maven-3.9.5-bin.tar.gz

# Google Chrome set up
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' && \
    apt-get update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Jenkins set up
RUN curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | tee \
    /usr/share/keyrings/jenkins-keyring.asc > /dev/null && \
    echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | tee \
    /etc/apt/sources.list.d/jenkins.list > /dev/null && \
    apt-get update && apt-get install -y jenkins && \
    rm -rf /var/lib/apt/lists/*

# Allure set up
RUN wget https://github.com/allure-framework/allure2/releases/download/2.32.0/allure-2.32.0.zip && \
    unzip allure-2.32.0.zip -d /opt && \
    ln -s /opt/allure-2.32.0/bin/allure /usr/bin/allure && \
    rm allure-2.32.0.zip

# Work directory set up
WORKDIR /app

# Environment variables set up for JDK and Maven
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:/opt/apache-maven-3.9.5/bin:/opt/allure-2.32.0/bin:$PATH"

# Open ports for Jenkins
EXPOSE 8080
EXPOSE 50000

CMD ["java", "-jar", "/usr/share/java/jenkins.war"]