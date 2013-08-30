package org.plukh.examples.properties;

import java.util.Properties;

public class Example4 {

/*
Example #4 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates lack of type-safety in java.util.Properties

By Victor S. Denisov, Lomonosov Moscow State University
 */


    public static void main(String[] args) {
        final Properties properties = new Properties();
        properties.setProperty("property", "A");
        int i = Integer.valueOf(properties.getProperty("property")); //Produces NumberFormatException
    }
}
