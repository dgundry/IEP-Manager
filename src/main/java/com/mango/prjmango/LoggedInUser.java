package com.mango.prjmango;

import com.mango.prjmango.utilities.DatabaseCommands;
import lombok.Getter;
import java.util.List;

public class LoggedInUser {

    @Getter private static int teacher_id;
    @Getter private static String firstName;
    @Getter private static String lastName;
    @Getter private static String email;

    public LoggedInUser(int teacher_id) {
        this.teacher_id = teacher_id;
        setFields(DatabaseCommands.getUserDetails(teacher_id));
    }

    private static void setFields(List<String> rawData) {
        firstName = rawData.get(0);
        lastName = rawData.get(1);
        email = rawData.get(2);
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ": " + email;
    }
}
