package com.mango.prjmango.student;

import lombok.Getter;
import java.util.Comparator;

/**
 * Fixed constants that allow us to sort by the fields within the {@link Student} object.
 */
public enum StudentSortTypes {

    STUDENT_ID(Comparator.comparing(Student::getStudentID)),
    FIRST_NAME(Comparator.comparing(Student::getFirstName)),
    LAST_NAME(Comparator.comparing(Student::getLastName)),
    GRADE(Comparator.comparing(Student::getGrade)),
    BIO(Comparator.comparing(Student::getBio));

    @Getter private Comparator<Student> comparator;

    /**
     * Constructor. Initializes the {@link Comparator} that can be accessed.
     *
     * @param comparator the {@link Comparator}
     */
    StudentSortTypes(Comparator<Student> comparator) {
        this.comparator = comparator;
    }
}
