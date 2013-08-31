package org.plukh.examples.preferences;

import java.util.prefs.Preferences;

/*
Example #4 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates lack of type-safety when setting values in Preferences API

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example4 {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Example4.class);

        prefs.putInt("property", 1);
        prefs.put("property", "string");

        int i = prefs.getInt("property", -1);
        System.out.println("property=" + i);
    }
}
