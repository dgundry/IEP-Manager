package com.mango.prjmango;

import com.mango.prjmango.utilities.DatabaseCommands;
import lombok.Getter;

import java.util.List;

public class LoggedInUser {
    private @Getter int teacher_id;
    private @Getter String firstName;
    private @Getter String lastName;
    private @Getter String email;

    public LoggedInUser(int teacher_id) {
        this.teacher_id = teacher_id;
        setFields(DatabaseCommands.getUserDetails(teacher_id));
    }
    private void setFields(List<String> rawData){
        firstName = rawData.get(0);
        lastName = rawData.get(1);
        email = rawData.get(2);
    }
    public String toString(){
        return firstName + ", " + lastName + ": " + email;
    }
}
