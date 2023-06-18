import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void zadanie1() {
        System.out.println("Pytanie 1: Czym jest i do czego służy println()?\n" +
                "Służy do wyświetlania/wydrukowania w konsoli przekazanych argumentów .\n");
        System.out.println("Pytanie 2: Jaka jest różnica pomiedzy while a do-while?\n" +
                "While najpierw sprawdza warunek, a następnie wykonuje instrukcję\n" +
                "Do while wykona instrukcję co najmniej raz, po czym sprawdzany jest warunek.\n");
        System.out.println("Pytanie 3: W jaki sposób można pobrać wartość logiczną?\n" +
                "Za pomocą metody nextBoolean().\n");
    }

    static void zadanie2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj zmienna typu int: ");
        int a = sc.nextInt();
        System.out.println("Podaj zmienna typu float: ");
        float b = sc.nextFloat();
        System.out.println("Podaj zmienna typu char: ");
        char c = sc.next().charAt(0);
        System.out.println("Podaj zmienna typu boolean: ");
        boolean d = sc.nextBoolean();
        System.out.println("int = " + a);
        System.out.println("float = " + b);
        System.out.println("char = " + c);
        System.out.println("boolean = " + d);
        sc.close();
    }

    static void zadanie3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj swoje imie i nazwisko: ");
        String name = sc.nextLine();
        System.out.println("Podaj swoja plec (M czy F): ");
        String sex = sc.nextLine();
        System.out.println("Podaj swoj wiek: ");
        int age = sc.nextInt();
        System.out.println("Twoje imie i nazwisko: " + name + ", twoja plec to: " + sex + ", twoj wiek to: " + age);
        sc.close();
    }

    static void zadanie4() {
        for (int i = -1000; i <= 1001; i += 3) {
            System.out.println(i);
        }
    }

    static void zadanie5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj 3 liczby: ");
        int curr = 0, max = 0;
        for (int i = 0; i < 3; ++i) {
            curr = sc.nextInt();
            if (curr > max) {
                max = curr;
            }
        }
        System.out.println("Najwieksza liczba to: " + max);
        sc.close();
    }

    static void zadanie6() {
        char operator;
        int l1, l2;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Operator: ");
            operator = sc.next().charAt(0);
            if (operator == 'q') {
                break;
            }

            System.out.println("Number 1: ");
            l1 = sc.nextInt();

            System.out.println("Number 2:");
            l2 = sc.nextInt();

            switch (operator) {
                case '+' -> System.out.println("Result: " + (l1 + l2));
                case '-' -> System.out.println("Result: " + (l1 - l2));
                case '/' -> System.out.println("Result: " + (l1 / l2));
                case '*' -> System.out.println("Result: " + (l1 * l2));
                default -> System.out.println("Invalid operator.");
            }
        }
    }

    static void zadanie7(int l1, int l2) {
        if (l2 == 0) System.out.println(l1);
        else zadanie7(l2, l1 % l2);
    }

    static void zadanie8(int[][] arr, int var) {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 4; ++j)
                if (arr[i][j] == var)
                    System.out.println("[" + i + "][" + j + "]");
    }

    public static void main(String[] args) {
        zadanie1();
//        zadanie2();
//        zadanie3();
//        zadanie4();
//        zadanie5();
//        zadanie6();
//        zadanie7(4, 22);

//        int[][] arr = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//        };
//        zadanie8(arr, 7);
    }
}