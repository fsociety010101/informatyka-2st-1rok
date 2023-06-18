package Genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Selection {
    private List<Integer> population;

    private List<Integer> newPopulation;

    public Selection(List<Integer> population) {
        this.population = population;
        this.newPopulation = new ArrayList<>();
    }

    public List<Integer> beginSelection(String selectionMethod) {
        switch (selectionMethod) {
            case "Metoda kola ruletki" -> rouletteSelection();
            case "Metoda rankingowa" -> rankingSelection();
            case "Metoda turnieju" -> tournamentSelection();
        }
        return this.newPopulation;
    }

    private void rouletteSelection() {
        System.out.println("\n*---------- Metoda kola ruletki ----------*\n");
        System.out.println("Populacja przed selekcja: " + this.population);

        // find sum of chromosome grades
        int sum = 0;
        for (Integer it : this.population) sum += it;
        System.out.println("Suma wszystkich ocen: " + sum);

        // "spinning" the roulette to create new population
        Random random = new Random();
        for (int i = 0; i < this.population.size(); ++i) {
            // randomly choosing fixed point
            // dla kazdej populacji mamy ustalony punkt
            int fixedPoint = random.nextInt(sum);
            System.out.println("\nFixed point -> " + fixedPoint);
            // spin offset to choose chromosome
            int spinOffset = 0;
            for (Integer it : this.population) {
                spinOffset += it;
                if (fixedPoint < spinOffset) {
                    this.newPopulation.add(it);
                    System.out.println("Dodano osobinka: " + it);
                    break;
                }
            }
        }

        System.out.println("\nNowa populacja: " + this.newPopulation);
    }

    private void rankingSelection() {
        System.out.println("\n*---------- Metoda rankingowa ----------*\n");
        System.out.println("\nPopulacja przed selekcja: " + this.population);

        // sort population
        Collections.sort(this.population);
        System.out.println("\nPosortowana populacja: " + this.population);

        // calculate sum of ranks
        int rankSum = 0;
        for (int i = 0; i < this.population.size(); ++i) rankSum += i + 1;
        System.out.println("Suma rankingow: " + rankSum);

        // "spinning" the roulette to create new population
        Random random = new Random();
        for (int i = 0; i < this.population.size(); ++i) {
            // randomly choosing fixed point
            int fixedPoint = random.nextInt(rankSum);
            System.out.println("\nFixed point -> " + fixedPoint);
            // spin offset to choose chromosome
            int spinOffset = 0;
            for (int j = 0; j < this.population.size(); ++j) {
                spinOffset += j + 1;
                if (fixedPoint < spinOffset) {
                    this.newPopulation.add(this.population.get(j));
                    System.out.println("Dodano osobinka z rankingiem " + (j + 1) + ": " + this.population.get(j));
                    break;
                }
            }
        }

        System.out.println("\nNowa populacja: " + this.newPopulation);
    }

    private void tournamentSelection() {
        System.out.println("\n*---------- Metoda turnieju ----------*\n");
        System.out.println("Populacja przed selekcja: " + this.population);

        Random random = new Random();
        for (int i = 0; i < this.population.size(); ++i) {
            System.out.println("\n---Proces znalezenia " + (i + 1) + " rodzica---");
            int bestChromosome = 0, tempChromosome = 0;
            for (int j = 0; j < this.population.size() / 2; ++j) {
                int randomPosition = random.nextInt(this.population.size());
                tempChromosome = this.population.get(randomPosition);
                System.out.println("Wylosowana pozycja: " + randomPosition);
                if (tempChromosome > bestChromosome) {
                    bestChromosome = tempChromosome;
                    System.out.println("Na tej pozycji znaleziono lepszego kandydata: " + bestChromosome + "\n");
                } else {
                    System.out.println("Na tej pozycji NIE znaleziono lepszego kandydata\n");
                }
            }
            this.newPopulation.add(bestChromosome);
            System.out.println("Dodano osobinka: " + bestChromosome);
        }

        System.out.println("\nNowa populacja: " + this.newPopulation);
    }
}
