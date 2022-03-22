package com.mango.prjmango.createaccount.mothers;

import com.mango.prjmango.utilities.User;
import com.mango.prjmango.utilities.GenericBuilder;

/**
 * This class helps reduce the duplicated code throughout the application.
 * The builder pattern provides a build object which is used to construct a complex object called the product.
 * It encapsulates the logic of constructing the different pieces of the product
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-30
 */
public class UserMother {

    public static GenericBuilder<User> getUser() {
        return GenericBuilder.of(User::new)
                .with(User::setFirstName, "John")
                .with(User::setLastName, "Smith")
                .with(User::setEmail, "jsmith@gmail.com")
                .with(User::setPassword1, new char[] { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' })
                .with(User::setPassword2, new char[] { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' })
                .with(User::setSecurityQ1, 1)
                .with(User::setSecurityQ2, 2)
                .with(User::setSecurityA1, "Answer 1")
                .with(User::setSecurityA2, "Answer 2");
    }
}
