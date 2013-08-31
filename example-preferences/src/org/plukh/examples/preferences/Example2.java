package org.plukh.examples.preferences;

import java.util.prefs.Preferences;

/*
Example #2 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates reading properties with Preferences API

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example2 {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Example2.class);

        System.out.println("property=" + prefs.get("property", "<undefined>"));
        System.out.println("int_property=" + prefs.getInt("int_property", -1));
        System.out.println("bool_property=" + prefs.getBoolean("bool_property", false));
        System.out.println("undefined_property=" + prefs.get("undefined_property", "<default_value>"));
    }
}
