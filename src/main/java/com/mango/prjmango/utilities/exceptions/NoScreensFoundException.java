package com.mango.prjmango.utilities.exceptions;

/**
 * This is called if there is an issue determining the screen the application is running on.
 */
public class NoScreensFoundException extends RuntimeException {

    /**
     * Constructs a new NoScreensFoundException with the provided error message.
     *
     * @param errorMessage the specific error message
     */
    public NoScreensFoundException(String errorMessage) {
        super(errorMessage);
    }
}
