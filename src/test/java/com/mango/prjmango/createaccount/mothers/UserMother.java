package com.mango.prjmango.createaccount.mothers;

import com.mango.prjmango.createaccount.User;
import com.mango.prjmango.utilities.GenericBuilder;

public class UserMother {

    public static GenericBuilder<User> getUser() {
        return GenericBuilder.of(User::new)
                .with(User::setFirstName, "John")
                .with(User::setLastName, "Smith")
                .with(User::setEmail, "jsmith@gmail.com")
                .with(User::setPassword1, "password")
                .with(User::setPassword2, "password")
                .with(User::setSecurityQ1, 1)
                .with(User::setSecurityQ2, 2)
                .with(User::setSecurityA1, "Answer 1")
                .with(User::setSecurityA2, "Answer 2");
    }
}
