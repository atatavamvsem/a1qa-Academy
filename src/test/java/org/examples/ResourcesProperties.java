package org.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcesProperties.class);
    private static FileInputStream fileConfigInputStream;
    private static FileInputStream fileTestDataInputStream;
    private static Properties CONF_PROPERTIES;
    private static Properties DATA_PROPERTIES;
    static {
        try {
            LOGGER.debug("Reading resource files");
            fileConfigInputStream = new FileInputStream("src/test/resources/conf.properties");
            fileTestDataInputStream = new FileInputStream("src/test/resources/testData.properties");
            CONF_PROPERTIES = new Properties();
            DATA_PROPERTIES = new Properties();
            CONF_PROPERTIES.load(fileConfigInputStream);
            DATA_PROPERTIES.load(fileTestDataInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileConfigInputStream != null && fileTestDataInputStream != null)
                try {
                    fileConfigInputStream.close();
                    fileTestDataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }

    public static String getConfProperty(String key) {
        return CONF_PROPERTIES.getProperty(key);
    }

    public static String getDataProperty(String key) {
        return DATA_PROPERTIES.getProperty(key);
    }
}
