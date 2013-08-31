package org.plukh.examples.commonsconfig;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Example4 {
    public static void main(String[] args) {
        final PropertiesConfiguration conf = new PropertiesConfiguration();
        conf.setProperty("array_property", "red, green, blue");
        String[] strings = conf.getStringArray("array_property");
        System.out.println("Got " + strings.length + " elements, first is " +
        strings[0] + ", second is " + strings[1] + " and third is " + strings[2]);
    }
}
