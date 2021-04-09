package org.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesProperties {
    protected static FileInputStream fileConfigInputStream;
    protected static FileInputStream fileTestDataInputStream;
    protected static Properties CONF_PROPERTIES;
    protected static Properties DATA_PROPERTIES;
    static {
        try {
            //указание пути до файла с настройками
            fileConfigInputStream = new FileInputStream("src/test/resources/conf.properties");
            fileTestDataInputStream = new FileInputStream("src/test/resources/testData.properties");
            CONF_PROPERTIES = new Properties();
            DATA_PROPERTIES = new Properties();
            CONF_PROPERTIES.load(fileConfigInputStream);
            DATA_PROPERTIES.load(fileTestDataInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileConfigInputStream != null && fileTestDataInputStream != null)
                try {
                    fileConfigInputStream.close();
                    fileTestDataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    /**
     * метод для возврата строки со значением из файла с настройками
     */
    public static String getConfProperty(String key) {
        return CONF_PROPERTIES.getProperty(key);
    }

    public static String getDataProperty(String key) {
        return DATA_PROPERTIES.getProperty(key);
    }
}
