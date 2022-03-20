package com.mango.prjmango.student;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestStudentSortTypes {

    private final List<Student> students = new ArrayList<>();

    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;
    private Student s5;

    @Before
    public void setUp() {
        s1 = new Student(0, "Kellen", "Campbell", "1", "Decent student");
        s2 = new Student(1, "Patrick", "Weaver", "2", "Good student");
        s3 = new Student(2, "Wes", "Noffsinger", "4", "Great student");
        s4 = new Student(3, "Devin", "Gundry", "2", "Great student");
        s5 = new Student(4, "Emily", "Robey", "5", "Terrible student");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    @Test
    public void testSortByID() {
        //Act
        students.sort(StudentSortTypes.STUDENT_ID.getComparator());
        List<Student> expected = new ArrayList<>(students);

        //Assert
        Assertions.assertThat(expected).containsExactly(s1, s2, s3, s4, s5);
    }

    @Test
    public void testSortByFirstName() {
        //Act
        students.sort(StudentSortTypes.FIRST_NAME.getComparator());
        List<Student> expected = new ArrayList<>(students);

        //Assert
        Assertions.assertThat(expected).containsExactly(s4, s5, s1, s2, s3);
    }

    @Test
    public void testSortByLastName() {
        //Act
        students.sort(StudentSortTypes.LAST_NAME.getComparator());
        List<Student> expected = new ArrayList<>(students);

        //Assert
        Assertions.assertThat(expected).containsExactly(s1, s4, s3, s5, s2);
    }

    @Test
    public void testSortByGrade() {
        //Act
        students.sort(StudentSortTypes.GRADE.getComparator());
        List<Student> expected = new ArrayList<>(students);

        //Assert
        Assertions.assertThat(expected).containsExactly(s1, s2, s4, s3, s5);
    }

    @Test
    public void testSortByBio() {
        //Act
        students.sort(StudentSortTypes.BIO.getComparator());
        List<Student> expected = new ArrayList<>(students);

        //Assert
        Assertions.assertThat(expected).containsExactly(s1, s2, s3, s4, s5);
    }
}
