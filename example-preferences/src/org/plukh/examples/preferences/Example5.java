package org.plukh.examples.preferences;

import java.awt.*;
import java.util.prefs.Preferences;

/*
Example #5 for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

This example demonstrates use of different default values in different reads of the same configuration property

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class Example5 {
    private interface AppConfig {
        String getApplicationDir();
    }

    private class Right {
        private class WindowsAppConfig implements AppConfig {
            @Override
            public String getApplicationDir() {
                Preferences prefs = Preferences.userNodeForPackage(Example5.class);
                return prefs.get("appDir", "C:\\Program Files\\App"); //One default for Windows OS
            }
        }

        private class GenericAppConfig implements AppConfig {
            @Override
            public String getApplicationDir() {
                Preferences prefs = Preferences.userNodeForPackage(Example5.class);
                return prefs.get("appDir", "/usr/bin/app"); //Different default for other OSes
            }
        }

        public AppConfig getAppConfig(String os) {
            if (os.toLowerCase().startsWith("windows")) return new WindowsAppConfig();
            else return new GenericAppConfig();
        }
    }

    private class Wrong {
        private double getWindowProportions(Rectangle rect) {
            Preferences prefs = Preferences.userNodeForPackage(Example5.class);
            return rect.getWidth()/rect.getHeight() * prefs.getInt("aspectRatio", 1); //First default
        }

        private double getWindowProportions(int x1, int y1, int x2, int y2) {
            Preferences prefs = Preferences.userNodeForPackage(Example5.class);
            return ((double)Math.abs(x2 - x1))/Math.abs(y2 - y1) * prefs.getInt("aspectRatio", 2); //Probably a typo
        }
    }

    public static void main(String[] args) {
        //Different defaults are used correctly
        System.out.println("Good:");
        Example5 example5 = new Example5();
        Right right = example5.getRight();
        System.out.println("Windows: " + right.getAppConfig("Windows XP").getApplicationDir());
        System.out.println("Linux: " + right.getAppConfig("Linux Debian").getApplicationDir());

        System.out.println();

        //Different defaults are used incorrectly
        System.out.println("Bad:");
        Wrong wrong = example5.getWrong();
        System.out.println("Using rectangle: " + wrong.getWindowProportions(new Rectangle(10, 10, 10, 10)));
        System.out.println("Using coordinates: " + wrong.getWindowProportions(10, 10, 20, 20));
    }

    public Right getRight() {
        return new Right();
    }

    public Wrong getWrong() {
        return new Wrong();
    }
}
