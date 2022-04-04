package com.mango.prjmango.ui.common.limitedtextfield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.regex.Pattern;

class JTextFieldFilterTest {

    @ParameterizedTest
    @ValueSource(strings = { "Kellen", "" })
    void testCharactersOnly_ZeroOrMore_Pass(String str) {
        //Arrange
        String regex = "^[a-zA-Z]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "Kellen", "a", "aA", "AA", "Aa" })
    void testCharactersOnly_OneOrMore_Pass(String str) {
        //Arrange
        String regex = "^[a-zA-Z]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "!", " ", "f13" })
    void testCharactersOnly_ZeroOrMore_Fail(String str) {
        //Arrange
        String regex = "^[a-zA-Z]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "!", "", " ", "f13" })
    void testCharactersOnly_OneOrMore_Fail(String str) {
        //Arrange
        String regex = "^[a-zA-Z]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "1", "" })
    void testNumbersOnly_ZeroOrMore_Pass(String str) {
        //Arrange
        String regex = "^[0-9]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "123", "1" })
    void testNumbersOnly_OneOrMore_Pass(String str) {
        //Arrange
        String regex = "^[0-9]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "f123", "f", " " })
    void testNumbersOnly_ZeroOrMore_Fail(String str) {
        //Arrange
        String regex = "^[0-9]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "f123", "f", "" })
    void testNumbersOnly_OneOrMore_Fail(String str) {
        //Arrange
        String regex = "^[0-9]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc123", "a", "a1", "1", "" })
    void testCharactersAndNumbers_ZeroOrMore_Pass(String str) {
        //Arrange
        String regex = "^[a-zA-Z0-9]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc123", "a", "a1", "1" })
    void testCharactersAndNumbers_OneOrMore_Pass(String str) {
        //Arrange
        String regex = "^[a-zA-Z0-9]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertTrue(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "!abc123", "a$", "a1%", "1 " })
    void testCharactersAndNumbers_ZeroOrMore_Fail(String str) {
        //Arrange
        String regex = "^[a-zA-Z0-9]*";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "!abc123", "a$", "a1%", "1 " })
    void testCharactersAndNumbers_OneOrMore_Fail(String str) {
        //Arrange
        String regex = "^[a-zA-Z0-9]+";

        //Act
        Pattern pattern = Pattern.compile(regex);

        //Assert
        Assertions.assertFalse(pattern.matcher(str).matches());
    }
}