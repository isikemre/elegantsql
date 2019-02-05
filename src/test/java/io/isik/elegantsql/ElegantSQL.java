package io.isik.elegantsql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElegantSQL {

    public static void main(String[] args) {
        String resourceName = "elegant.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
            Elegant.makeItElegant("io.isik.elegantsql", props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
