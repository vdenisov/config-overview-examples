package org.plukh.examples.properties;

import java.util.Properties;

/*
Example #3 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates an unexpected result when mixing Map and Properties methods

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example3 {

    public static void main(String[] args) {
        //Instantiate properties object and set some property values
        final Properties properties = new Properties();
        properties.put("property", 1); //Will produce an unexpected result later

        //Output property values (somewhat unexpected result)
        System.out.println("property=" + properties.getProperty("property"));
    }
}
