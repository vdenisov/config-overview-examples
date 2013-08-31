package org.plukh.examples.preferences;

import java.util.Stack;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/*
Utility class for the article "Overview of Java Application Configuration Frameworks" published in
International Journal of Open Information Technologies.

By Victor S. Denisov, Lomonosov Moscow State University
*/

public class PrefUtils {
    public static void printPreferences(final Preferences preferences) {
        try {
            Stack<Preferences> prefStack = new Stack<Preferences>();
            prefStack.push(preferences);

            while (!prefStack.isEmpty()) {
                Preferences node = prefStack.pop();
                System.out.println(getSpacesForNode(node) + "[" + node.name() + "]");

                String[] children = node.childrenNames();
                for (String child : children) {
                    prefStack.push(node.node(child));
                }

                final String spaces = getSpacesForKey(node);
                for (String key : node.keys()) {
                    System.out.println(spaces + key + "=" + node.get(key, "<undefined>"));
                }
            }
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    private static String getSpacesForNode(Preferences node) {
        final int depth = getDepth(node);
        return depth == 0 ? "" : String.format("%" + (depth * 2) + "s", "");
    }

    private static String getSpacesForKey(Preferences node) {
        final int depth = getDepth(node);
        return depth == 0 ? "" : String.format("%" + (depth * 2 + 2) + "s", "");
    }

    private static int getDepth(Preferences node) {
        return node.absolutePath().split("/").length;
    }
}
