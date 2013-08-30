package org.plukh.examples.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Example1 {

/*
Example #1 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates basic java.util.Properties instantiation and file-based persistence.

By Victor S. Denisov, Lomonosov Moscow State University
 */


    public static void main(String[] args) {
        //Instantiate properties object and set some property values
        final Properties properties = new Properties();
        properties.setProperty("property", "value");
        properties.setProperty("another.property", "value2");

        //Store properties to file
        try (FileOutputStream out = new FileOutputStream("example1.properties")) {
            properties.store(out, "Example1 properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
