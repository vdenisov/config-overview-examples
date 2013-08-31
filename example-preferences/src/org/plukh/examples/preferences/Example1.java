package org.plukh.examples.preferences;

import java.util.prefs.Preferences;

/*
Example #1 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates setting properties with Preferences API

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example1 {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Example1.class);

        prefs.put("property", "value");
        prefs.putInt("int_property", 1);
        prefs.putBoolean("bool_property", true);

        PrefUtils.printPreferences(Preferences.userRoot());
    }
}
