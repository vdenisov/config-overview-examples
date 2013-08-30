package org.plukh.examples.commonsconfig;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;

/*
Example #2 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates management of properties file layout via PropertiesConfigurationLayout class

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example4 {
    public static void main(String[] args) {
        final PropertiesConfiguration conf = new PropertiesConfiguration();

        conf.addConfigurationListener(new ConfigurationListener() {
            @Override
            public void configurationChanged(ConfigurationEvent event) {
                System.out.println("Configuration changed: " + getEventTypeByCode(event.getType()) +
                        " before update: " + event.isBeforeUpdate() + " (" + event.getPropertyName() + "=" + event.getPropertyValue() + ")");
            }
        });

        conf.addProperty("propertyA", "valueA");
        conf.setProperty("propertyA", "valueB");
        conf.clear();
    }

    private static String getEventTypeByCode(int code) {
        switch (code) {
            case PropertiesConfiguration.EVENT_ADD_PROPERTY: return "EVENT_ADD_PROPERTY";
            case PropertiesConfiguration.EVENT_SET_PROPERTY: return "EVENT_SET_PROPERTY";
            case PropertiesConfiguration.EVENT_READ_PROPERTY: return "EVENT_READ_PROPERTY";
            case PropertiesConfiguration.EVENT_CLEAR_PROPERTY: return "EVENT_CLEAR_PROPERTY";
            case PropertiesConfiguration.EVENT_CLEAR: return "EVENT_CLEAR";
            default: return "*** unknown event ***";
        }
    }
}
