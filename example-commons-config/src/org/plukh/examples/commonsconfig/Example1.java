package org.plukh.examples.commonsconfig;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/*
Example #1 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates basic PropertiesConfiguration instantiation and file-based persistence

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example1 {
    public static void main(String[] args) {
        final PropertiesConfiguration configuration = new PropertiesConfiguration();
        configuration.setProperty("property", "value");
        configuration.setHeader("Example1 properties configuration");
        try {
            configuration.save("example1.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
