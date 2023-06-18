package Genetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossover {
    int index1, index2;
    private List<Integer> parent1, parent2, child1, child2;

    public Crossover(List<Integer> parent1, List<Integer> parent2, int index1, int index2) {
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.child1 = new ArrayList<>();
        this.child2 = new ArrayList<>();
        this.index1 = index1;
        this.index2 = index2;
    }

    public List<Integer> getChild1() {
        return child1;
    }

    public List<Integer> getChild2() {
        return child2;
    }

    public void beginCrossover(String crossoverMethod) {
        switch (crossoverMethod) {
            case "Krzyzowanie jednopunktowe" -> onePoint();
            case "Krzyzowanie dwupunktowe" -> twoPoint();
        }
    }

    private void printChromosomesOnePoint(List<Integer> chromosome, int crossoverPoint) {
        System.out.print("[ ");
        for (int i = 0; i < this.parent1.size(); ++i) {
            if (i == crossoverPoint - 1) System.out.print(chromosome.get(i) + " * ");
            else System.out.print(chromosome.get(i) + " ");
        }
        System.out.print("]\n");
    }

    private void printChromosomesTwoPoint(List<Integer> chromosome, int crossoverPoint1, int crossoverPoint2) {
        System.out.print("[ ");
        for (int i = 0; i < this.parent1.size(); ++i) {
            if (i == crossoverPoint1 - 1) System.out.print(chromosome.get(i) + " * ");
            else if (i == crossoverPoint2 - 1) System.out.print(chromosome.get(i) + " * ");
            else System.out.print(chromosome.get(i) + " ");
        }
        System.out.print("]\n");
    }

    public void onePoint() {
        System.out.println("\n*---------- Krzyzowanie jednopunktowe dla chromosomow nr [" + index1 + "] oraz nr [" + index2 + "] ----------*");

        // losowanie punktu krzyzowania
        Random random = new Random();
        int crossoverPoint = random.nextInt(this.parent1.size());
        System.out.println("Punkt krzyzowania: " + crossoverPoint);


        for (int i = 0; i < this.parent1.size(); ++i) {
            // before crossover point - 1 part of each parent
            if (i < crossoverPoint) {
                this.child1.add(this.parent1.get(i));
                this.child2.add(this.parent2.get(i));

            }
            // after crossover point - 2 part of each parent
            else {
                this.child1.add(this.parent2.get(i));
                this.child2.add(this.parent1.get(i));
            }
        }
        System.out.println("Rodzic nr [1]:");
        printChromosomesOnePoint(this.parent1, crossoverPoint);

        System.out.println("Rodzic nr [2]:");
        printChromosomesOnePoint(this.parent2, crossoverPoint);

        System.out.println("Dziecko nr [1]:");
        printChromosomesOnePoint(this.child1, crossoverPoint);

        System.out.println("Dziecko nr [2]:");
        printChromosomesOnePoint(this.child2, crossoverPoint);
    }

    public void twoPoint() {
        System.out.println("\n*---------- Krzyzowanie dwupunktowe dla chromosomow nr [" + index1 + "] oraz nr [" + index2 + "] ----------*");

        // randomly choosing two points until meet requirements
        Random random = new Random();
        int crossoverPoint1 = 0;
        int crossoverPoint2 = 0;
        while (true) {
            crossoverPoint1 = random.nextInt(this.parent1.size());
            crossoverPoint2 = random.nextInt(this.parent1.size());

            // if 1 > 2 then swap
            if (crossoverPoint1 > crossoverPoint2) {
                int temp = crossoverPoint1;
                crossoverPoint1 = crossoverPoint2;
                crossoverPoint2 = temp;
            }

            // find  and check diff
            int diffStart = crossoverPoint1 - 0;
            int diffPoint = crossoverPoint2 - crossoverPoint1;
            int diffEnd = this.parent1.size() - crossoverPoint2;
            // if all parts > than 25 (half of size) then reselect
            if (diffStart < 25 && diffPoint < 25 && diffEnd < 25) break;
        }

        System.out.println("Punkt krzyzowania nr 1: " + crossoverPoint1);
        System.out.println("Punkt krzyzowania nr 2: " + crossoverPoint2);

        // from start to crossover point 1
        for (int i = 0; i < crossoverPoint1; i++) {
            this.child1.add(this.parent1.get(i));
            this.child2.add(this.parent2.get(i));
        }
        // from crossover point 1 to crossover point 2
        for (int i = crossoverPoint1; i < crossoverPoint2; i++) {
            this.child1.add(this.parent2.get(i));
            this.child2.add(this.parent1.get(i));
        }
        // from crossover point 2 to end
        for (int i = crossoverPoint2; i < this.parent1.size(); i++) {
            this.child1.add(this.parent1.get(i));
            this.child2.add(this.parent2.get(i));
        }

        System.out.println("Rodzic nr [1]:");
        printChromosomesTwoPoint(this.parent1, crossoverPoint1, crossoverPoint2);

        System.out.println("Rodzic nr [2]:");
        printChromosomesTwoPoint(this.parent2, crossoverPoint1, crossoverPoint2);

        System.out.println("Dziecko nr [1]:");
        printChromosomesTwoPoint(this.child1, crossoverPoint1, crossoverPoint2);

        System.out.println("Dziecko nr [2]:");
        printChromosomesTwoPoint(this.child2, crossoverPoint1, crossoverPoint2);

    }
}
