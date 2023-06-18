import Genetics.Population;
import Genetics.Crossover;
import Genetics.Selection;

import java.util.Scanner;

public class Main {
    public static <List> void main(String[] args) {
        // get population size from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj ilosc osobnikow: ");
        int populationSize = 0;
        while (true) {
            populationSize = sc.nextInt();
            if (populationSize <= 1) System.out.println("Wartosc powinna byc > 1.");
            else break;
        }

        // init and display created population
        Population gen = new Population(populationSize);

        // choose selection method
        System.out.println("Wybierz metode selekcji: ");
        System.out.println("[1] - Metoda kola ruletki\n[2] - Metoda rankingowa\n[3] - Metoda turnieju");
        String selectionMethod = "default";
        while (selectionMethod.equals("default")) {
            int temp = sc.nextInt();
            switch (temp) {
                case 1 -> selectionMethod = "Metoda kola ruletki";
                case 2 -> selectionMethod = "Metoda rankingowa";
                case 3 -> selectionMethod = "Metoda turnieju";
                default -> System.out.println("Blad! Sprobuj ponownie.");
            }
        }

        // choose crossover method
        System.out.println("\nWybierz metode krzyzowania: ");
        System.out.println("[1] - Jednopunktowe\n[2] - Dwupunktowe");
        String crossoverMethod = "default";
        while (crossoverMethod.equals("default")) {
            int temp = sc.nextInt();
            switch (temp) {
                case 1 -> crossoverMethod = "Krzyzowanie jednopunktowe";
                case 2 -> crossoverMethod = "Krzyzowanie dwupunktowe";
                default -> System.out.println("Blad! Sprobuj ponownie.");
            }
        }

        // init methods
        gen.setMethods(selectionMethod, crossoverMethod);

        // begin GA
        gen.beginGeneticsAlgorithm();
    }
}