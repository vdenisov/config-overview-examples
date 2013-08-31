package org.plukh.examples.preferences;

import java.util.prefs.Preferences;

/*
Example #3 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates use of default values to achieve limited type-safety with Preferences API

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example3 {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Example3.class);

        prefs.put("property", "value");
        int i = prefs.getInt("property", 1);
        System.out.println("property=" + i);
    }
}
