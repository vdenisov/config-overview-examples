package org.plukh.examples.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
Example #2 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example shows how java.util.Properties can be loaded from from file-based store

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example2 {
    public static void main(String[] args) {
        //Instantiate properties object
        final Properties properties = new Properties();

        //Load properties from file
        try (FileInputStream in = new FileInputStream("example1.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Output property values
        properties.list(System.out);
    }
}
