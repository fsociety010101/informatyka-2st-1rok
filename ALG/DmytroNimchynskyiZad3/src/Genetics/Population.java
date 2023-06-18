package Genetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Population {
    private List<List<Integer>> population, newPopulation;
    private List<Integer> bestChromosome;
    private int populationSize = 0, bestCounter = 0, bestScore = 0, bestChromosomeIndex = 0, bestChromosomeGeneration = 0, generation = 0;
    private String selectionMethod, crossoverMethod;

    public Population(int size) {
        createPopulation(size);
        displayPopulation(this.population);
    }

    private void createPopulation(int size) {
        // init values
        this.populationSize = size;
        this.population = new ArrayList<>();
        this.newPopulation = new ArrayList<>();
        this.bestChromosome = new ArrayList<>();

        // populate with random genes and evaluate score for each chromosome
        Random random = new Random();
        for (int i = 0; i < this.populationSize; i++) {
            List<Integer> chromosome = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                // geny od 10 do 99
                // int random_integer = rand.nextInt(max-min) + min;
                chromosome.add(random.nextInt(99 - 10) + 10);
            }
            // add list of genes to appropriate member
            this.population.add(chromosome);

            // evaluate grades for each chromosome and in the meantime search for the best chromosome
            // this.evaluatedPopulation.add(evaluateGrade(chromosome, i));
        }
    }

    private int evaluateGrade(List<Integer> chromosome, int index) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < chromosome.size(); i++) {
            if (i % 2 == 0) evenSum += chromosome.get(i) * 2; // x2 to avoid negative scores
            else oddSum += chromosome.get(i);
        }
        int score = evenSum - oddSum;
        if (score > this.bestScore) {
            // reset best counter and rewrite all vars
            this.bestCounter = 0;
            this.bestChromosome = chromosome;
            this.bestScore = score;
            this.bestChromosomeIndex = index;
            this.bestChromosomeGeneration = this.generation;
        }
        return score;
    }

    private void displayPopulation(List<List<Integer>> population) {
        System.out.println("\n--- GENERACJA NUMER " + this.generation + " ---");
        System.out.println("Ilosc osobnikow: " + populationSize);
        for (int i = 0; i < population.size(); ++i) {
            System.out.println("Osobnik [" + i + "]: ");
            System.out.println(population.get(i));
            System.out.println("Ocena: " + evaluateGrade(population.get(i), i) + "\n");
        }
        System.out.println("Najlepszy osobnik: " + this.bestScore + " z indeksem [" + this.bestChromosomeIndex + "] z generacji [" + this.bestChromosomeGeneration + "]");
    }

    public void setMethods(String selectionMethod, String crossoverMethod) {
        this.selectionMethod = selectionMethod;
        this.crossoverMethod = crossoverMethod;
        System.out.println("\nWybrane metody dla danej populacji: " + this.selectionMethod + " i " + this.crossoverMethod + ".");
    }

    private void bestByGeneration() {
        int prevBestScore = 0;
        while (this.bestCounter <= 1000) {
            // call selection method and get new population after selection
            for (int i = 0; i < this.populationSize; ++i) {
                Selection selectionClass = new Selection(this.population.get(i));
                List<Integer> newChromosome = selectionClass.beginSelection(this.selectionMethod);
                this.newPopulation.add(newChromosome);
            }

            // call crossover method and get new population after crossover
            List<List<Integer>> newestPopulation = new ArrayList<>();
            for (int i = 1; i < this.populationSize; i += 2) {
                Crossover crossoverClass = new Crossover(this.newPopulation.get(i - 1), this.newPopulation.get(i), i - 1, i);
                crossoverClass.beginCrossover(this.crossoverMethod);
                newestPopulation.add(crossoverClass.getChild1());
                newestPopulation.add(crossoverClass.getChild2());
            }

            // update generation and display new population after selection and crossover and update best chromosome
            this.generation++;
            displayPopulation(newestPopulation);

            // compare and increment best counter
            if (this.bestScore == prevBestScore) {
                if (this.generation != this.bestChromosomeGeneration)
                    this.bestCounter += 1;
            } else if (this.bestScore > prevBestScore) {
                // write previous best to compare with new
                prevBestScore = this.bestScore;
            }

        }
        System.out.println("\n\nAlgorytm genetyczny zakonczony! Najlepszy osobnik pozostaje taki sam przez ostatnie 1000 pokolen.");
        System.out.println("Najlepszy osobnik z indeksem [" + this.bestChromosomeIndex + "] => " + this.bestChromosome);
        System.out.println("Jego wynik: " + this.bestScore);
        System.out.println("Generacja: " + this.bestChromosomeGeneration);
    }

    private void bestByScore() {
        while (true) {
            // call selection method and get new population after selection
            for (int i = 0; i < this.populationSize; ++i) {
                Selection selectionClass = new Selection(this.population.get(i));
                List<Integer> newChromosome = selectionClass.beginSelection(this.selectionMethod);
                this.newPopulation.add(newChromosome);
            }

            // call crossover method and get new population after crossover
            List<List<Integer>> newestPopulation = new ArrayList<>();
            for (int i = 1; i < this.populationSize; i += 2) {
                Crossover crossoverClass = new Crossover(this.newPopulation.get(i - 1), this.newPopulation.get(i), i - 1, i);
                crossoverClass.beginCrossover(this.crossoverMethod);
                newestPopulation.add(crossoverClass.getChild1());
                newestPopulation.add(crossoverClass.getChild2());
            }

            // update generation and display new population after selection and crossover and update best chromosome
            this.generation++;
            displayPopulation(newestPopulation);

            if (this.bestScore >= 2500) break;
        }
        System.out.println("\n\nAlgorytm genetyczny zakonczony!");
        System.out.println("Osobnik z indeksem [" + this.bestChromosomeIndex + "] osiagnal wynik 2500 => " + this.bestChromosome);
        System.out.println("Jego wynik: " + this.bestScore);
        System.out.println("Generacja: " + this.bestChromosomeGeneration);
    }

    public void beginGeneticsAlgorithm() {
        Scanner sc = new Scanner(System.in);
        // choose selection method
        System.out.println("Wybierz metode znalezenia najlepszego osobnika: ");
        System.out.println("[1] - Najlepszy za ostatnie 1000 generacji\n[2] - Pierwszy ktory osiagnie wynik 2500 (najlepiej dziala z >= 1000 osobnikow)");
        int searchBest = 0;
        while (true) {
            searchBest = sc.nextInt();
            if (searchBest == 1) {
                bestByGeneration();
                break;
            }
            if (searchBest == 2) {
                bestByScore();
                break;
            } else {
                System.out.println("Blad! Sprobuj ponownie.");
            }
        }
    }
}
