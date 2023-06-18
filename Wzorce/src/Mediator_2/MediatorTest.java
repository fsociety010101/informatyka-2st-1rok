package Mediator_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {
    public static Mediator mediator;
    @BeforeAll
    static void prepare(){
        mediator = new Mediator();


    }
    @Test
    void test_1(){
        Prowadzacy prowadzacy = new Prowadzacy(0, mediator);
        Student student = new Student(mediator, 0);
        Student student_1 = new Student(mediator, 1);
        Student student_2 = new Student(mediator, 2);
        mediator.add_prow(prowadzacy);
        mediator.add_stud(student);
        mediator.add_stud(student_1);
        mediator.add_stud(student_2);
        prowadzacy.zamiesc_ogloszenie("Adam Kobus Jest najlepszym prowadzącym");


    }

}