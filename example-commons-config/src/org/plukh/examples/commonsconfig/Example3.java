package org.plukh.examples.commonsconfig;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/*
Example #3 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates management of properties file layout via PropertiesConfigurationLayout class

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example3 {
    public static void main(String[] args) {
        final PropertiesConfiguration conf = new PropertiesConfiguration();
        try {
            conf.load("example3.properties");
            conf.addProperty("newproperty", "newvalue");

            System.out.println("File with added property, no layout changes");
            System.out.println("-------------------------------------------");

            conf.save(System.out);

            System.out.println("-------------------------------------------");
            System.out.println();

            conf.getLayout().setComment("newproperty", "Comment for a new property");
            conf.getLayout().setBlancLinesBefore("newproperty", 1);

            System.out.println("File with added property, changed layout");
            System.out.println("----------------------------------------");

            conf.save(System.out);
            System.out.println("----------------------------------------");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }
}
