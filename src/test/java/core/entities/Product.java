package core.entities;

import java.util.Objects;
import java.util.Optional;

public class Product {
    private String name;
    private double price;
    private Optional<String> productCode;
    private Optional<String> brand;
    private Optional<String> availability;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.productCode = builder.productCode;
        this.brand = builder.brand;
        this.availability = builder.availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Optional<String> getProductCode() {
        return productCode;
    }

    public void setProductCode(Optional<String> productCode) {
        this.productCode = productCode;
    }

    public Optional<String> getBrand() {
        return brand;
    }

    public void setBrand(Optional<String> brand) {
        this.brand = brand;
    }

    public Optional<String> getAvailability() {
        return availability;
    }

    public void setAvailability(Optional<String> availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(availability, product.availability);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productCode=" + productCode +
                ", brand=" + brand +
                ", availability=" + availability +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, productCode, brand, availability);
    }

    public static class ProductBuilder {
        private String name;
        private double price;
        private Optional<String> productCode = Optional.empty();
        private Optional<String> brand = Optional.empty();
        private Optional<String> availability = Optional.empty();

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withProductCode(String productCode) {
            this.productCode = Optional.ofNullable(productCode);
            return this;
        }

        public ProductBuilder withBrand(String brand) {
            this.brand = Optional.ofNullable(brand);
            return this;
        }

        public ProductBuilder withAvailability(String availability) {
            this.availability = Optional.ofNullable(availability);
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
