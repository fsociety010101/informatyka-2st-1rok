package visitor;

import decorator.Decorator;
import decorator.MovingAverage;
import decorator.Normalizer;
import decorator.Shifter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestVisitor {

    @Test
    void testSalaryRaiseAdmHigher(){
        //given
        Visitor v = new SalaryRaiser(2000.0);
        Visited employee = new VisitedAdministration(2500.0, 0.10);


        //when
        employee.acceptVisit(v);

        //then
        assertEquals(2725.0, employee.getSalary());
    }

    @Test
    void testSalaryRaiseAdmLower(){
        //given
        Visitor v = new SalaryRaiser(2000.0);
        Visited employee = new VisitedAdministration(1500.0, 0.10);

        //when
        employee.acceptVisit(v);

        //then
        assertEquals(2200.0, employee.getSalary());
    }

    @Test
    void testSalaryRaiseCommHigher(){
        //given
        Visitor v = new SalaryRaiser(2000.0);
        Visited employee = new VisitedCommonEmployee(2500.0);

        //when
        employee.acceptVisit(v);

        //then
        assertEquals(2500.0, employee.getSalary());
    }

    @Test
    void testSalaryRaise(){
        //given
        Visitor v = new SalaryRaiser(2000.0);
        Visited employee = new VisitedCommonEmployee(1500.0);

        //when
        employee.acceptVisit(v);

        //then
        assertEquals(2000.0, employee.getSalary());
    }


}
