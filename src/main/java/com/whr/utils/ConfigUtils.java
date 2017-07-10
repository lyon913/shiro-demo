package com.whr.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedBuilderProperties;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.PropertiesBuilderParameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * Created by Lyon on 2017/7/10.
 */
public class ConfigUtils {
    private static Configuration config;

    static {
        try {
            Parameters params = new Parameters();
            PropertiesBuilderParameters p = params.properties().setEncoding("UTF-8");
            Configurations configs = new Configurations();
            config = configs.properties("config.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getString(String name){
        return config.getString(name);
    }

    public static int getInt(String name){
        return config.getInt(name);
    }

    public static String[] getStringArray(String name){
        return config.getStringArray(name);
    }
}
