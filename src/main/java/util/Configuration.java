package util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class Configuration {

    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);
    private static Properties config;

    static {
        initConfig();
    }

    public static void initConfig() {
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader("config.properties"));
            config = new Properties();
            config.load(input);
            input.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to load properties file ", e);
        }
    }

    public static String get(String key) {
        String value = config.getProperty(key);
        if(StringUtils.isBlank(value)) {
            LOGGER.warn(String.format("Unable to resolve config property: [%s]", key));
        }
        return value;
    }
}
