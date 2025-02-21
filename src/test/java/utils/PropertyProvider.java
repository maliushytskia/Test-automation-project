package utils;

import core.Constants;

import java.util.Properties;

public class PropertyProvider {
    public static final Properties urlProperties =
            new PropertiesReader(Constants.PROPERTY_PATH + "endpoint.properties").getProperties();
}
