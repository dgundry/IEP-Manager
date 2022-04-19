package com.mango.prjmango;

import com.mango.prjmango.utilities.dbcommands.UserCommands;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Keeps track of the currently logged-in user throughout the application.
 */
public class LoggedInUser {

    @Getter private static int teacherId;
    @Getter @Setter private static String firstName;
    @Getter @Setter private static String lastName;
    @Getter @Setter private static String email;
    @Getter @Setter private static int securityQuestion1Index;
    @Getter @Setter private static int securityQuestion2Index;

    @Getter @Setter private static int accountSubTabIndex    = 0;
    @Getter @Setter private static int studentsSubTabIndex   = 0;
    @Getter @Setter private static int activitiesSubTabIndex = 0;
    @Getter @Setter private static int reportsSubTabIndex    = 0;

    /**
     * Constructor. Calls {@link LoggedInUser#setFields(List)} to set values to variables that will be accessed
     * throughout the application.
     * 
     * @param teacherId the specific {@code teacher_id} within the iepCipher database.
     */
    public LoggedInUser(int teacherId) {
        this.teacherId = teacherId;
        setFields(UserCommands.getUserDetails(teacherId));
    }

    private static void setFields(List<String> rawData) {
        firstName = rawData.get(0);
        lastName = rawData.get(1);
        email = rawData.get(2);
    }

    /**
     * String representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return firstName + ", " + lastName + ": " + email;
    }
}
