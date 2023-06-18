import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // przyklad z pdf
        TuringMachine tmTest = new TuringMachine();
        tmTest.readTuringMachineFromFile("dataTest.txt");
        tmTest.displayTuringMachine();
        tmTest.runTuringMachine();
        tmTest.writeToFile();
        System.out.println("\n\n\n\n");

        // przyklady z zajec
//        TuringMachine tm1 = new TuringMachine();
//        tm1.readTuringMachineFromFile("data1.txt");
//        tm1.displayTuringMachine();
//        tm1.runTuringMachine();
//        tm1.writeToFile();
//        System.out.println("\n\n\n\n");
//
//        TuringMachine tm2 = new TuringMachine();
//        tm2.readTuringMachineFromFile("data2.txt");
//        tm2.displayTuringMachine();
//        tm2.runTuringMachine();
//        tm2.writeToFile();
//        System.out.println("\n\n\n\n");
//
//        TuringMachine tm3 = new TuringMachine();
//        tm3.readTuringMachineFromFile("data3.txt");
//        tm3.displayTuringMachine();
//        tm3.runTuringMachine();
//        tm3.writeToFile();
//        System.out.println("\n\n\n\n");

    }
}

