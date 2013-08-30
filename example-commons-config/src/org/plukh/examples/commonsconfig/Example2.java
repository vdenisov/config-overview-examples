package org.plukh.examples.commonsconfig;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/*
Example #2 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates loading configuration from properties file into the PropertiesConfiguration object

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example2 {
    public static void main(String[] args) {
        final PropertiesConfiguration conf = new PropertiesConfiguration();
        try {
            conf.load("example1.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        System.out.println("property=" + conf.getString("property"));
    }
}
