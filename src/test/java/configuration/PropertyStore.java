package configuration;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum PropertyStore {
    //enum do trzymania statycznych danych
    BROWSER("browser"), //ten klucz ma byc taki jak w propertisach
    BROWSER_EXPLICIT_TIMEOUT("browser.explicit.timeout"),
    BROWSER_IMPLICIT_TIMEOUT("browser.implicit.timeout"),
    BROWSER_HEADLESS("browser.headless"),
    BROWSER_ATTACH_SCREENSHOT("browser.attachscreenshot"),
    ENVIRONMENT("environment");

    private String value;
    private String propertyKey;
    public static final String CONFIG_PROPERTIES = "config.properties";
    private static Properties properties = null;

    private PropertyStore(String key) {
        this.propertyKey = key;
        this.value = this.retrieveValue(key); //wartosc z configu
    }

    private String retrieveValue(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : getValueFromConfigFile(key);//pierwszy raz musi wziac dane z config.properties
    }

    private String getValueFromConfigFile(String key) {
        if (properties == null) { //jesli jeszcze z niego nie korzystalam to załaduj
            properties = loadConfigFile();
        }
        Object objFile = properties.get(key);
        return objFile != null ? Objects.toString(objFile) : null;
        //castowanie do stringa
    }

    private Properties loadConfigFile() {
        Properties copy = null; //pomocnicza referencja do properties
        try {
            InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            //do znalezienia pliku config.properties, wykorzystane stream
            try {
                Properties properties = new Properties();
                properties.load(confFileStream);
                copy = properties;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (confFileStream != null) {
                    try {
                        confFileStream.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.value);
    }

    public int getIntValue() {
        return Integer.parseInt((this.retrieveValue(this.propertyKey)));
    }

    public boolean getBoolean() {
        return this.isSpecified() && Boolean.parseBoolean(this.value);
    }

    public String getValue() {
        return this.retrieveValue(this.propertyKey);
    }
}
