package com.mango.prjmango.utilities;

/**
 * This class returns the type Operating System
 * the current user is on.
 */
public class OSUtils {

    public enum OS {
        WINDOWS, MAC
    }

    private static OS os = null;

    /**
     * Returns an OS type Enum that the user is on.
     *
     * @return the OS type the user is on
     */
    public static OS getOS() {
        if (os == null) {
            String operSys = System.getProperty("os.name").toLowerCase();

            if (operSys.contains("win")) {
                os = OS.WINDOWS;
            } else if (operSys.contains("mac")) {
                os = OS.MAC;
            }
        }
        return os;
    }
}
