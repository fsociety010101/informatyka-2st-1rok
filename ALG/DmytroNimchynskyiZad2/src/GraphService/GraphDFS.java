package GraphService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFS {
    private final int verticesAmount, edgesAmount;
    private final ArrayList<ArrayList<Integer>> adjacencyList;
    private String[] verticesColors;
    private Stack<Integer> stack;
    private LinkedList<Integer> visited;

    public GraphDFS(int verticesAmount, int edgesAmount, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.verticesAmount = verticesAmount;
        this.edgesAmount = edgesAmount;
        this.adjacencyList = adjacencyList;
        this.verticesColors = new String[this.verticesAmount + 1]; // +1 bc starting from vertice n1
        Arrays.fill(verticesColors, "Not colored");
        this.stack = new Stack<>();
        this.visited = new LinkedList<>();

        bipartiteDFS(1);
    }

    private void bipartiteDFS(int verticeCurrent) {
        System.out.println("\n*** Checking if graph is bipartite using DFS... ***\n");

        // start inline dfs
        inlineDFS(verticeCurrent);

        // start dfs recursivley, mark 1 as visited(colored)
        /*

        System.out.println("Start vertice is [1]. Coloring [1] in Red.");
        this.verticesColors[verticeCurrent] = "Red";
        if (recursiveDFS(verticeCurrent)) {
            System.out.println("Graph is colored successfully and is bipartite!");
        } else {
            System.out.println("\nThis graph is not bipartite!");
        }

        */
    }


    private void inlineDFS(int verticeCurrent) {
        int previous = verticeCurrent;
        stack.push(verticeCurrent);
        while (!stack.isEmpty()) {
            verticeCurrent = stack.pop();
            this.visited.add(verticeCurrent); // to display visited vertices in terminal

            if (this.verticesColors[verticeCurrent] == "Not colored") {
                if (verticeCurrent == 1) {
                    // mark 1 as visited(colored) and add to queue
                    System.out.println("Start vertice is [1]. Coloring [1] in Red.");
                    this.verticesColors[verticeCurrent] = "Red";
                } else if (this.verticesColors[previous] == "Red") {
                    this.verticesColors[verticeCurrent] = "Green";
                    System.out.println("Current vertice: [" + previous + "] - " + this.verticesColors[previous] + ".");
                    System.out.println("Coloring [" + verticeCurrent + "] in Green.");
                } else {
                    this.verticesColors[verticeCurrent] = "Red";
                    System.out.println("Current vertice: [" + previous + "] - " + this.verticesColors[previous] + ".");
                    System.out.println("Coloring [" + verticeCurrent + "] in Red.");
                }

                // get list of all neighbours for current vertice and iterate through it
                ArrayList<Integer> currentNeighbours = this.adjacencyList.get(verticeCurrent);
                for (Integer it : currentNeighbours) {
                    if (this.verticesColors[it] == "Not colored") {
                        stack.push(it);
                    } else if (this.verticesColors[verticeCurrent] == this.verticesColors[it]) {
                        System.out.println("\n" + this.visited + " <- " + this.stack);
                        System.out.println("Current vertice: [" + verticeCurrent + "] - " + this.verticesColors[verticeCurrent] + ".");
                        if (this.verticesColors[verticeCurrent] == "Red") {
                            System.out.println("Conflict! Cannot color [" + verticeCurrent + "]'s neighbour [" + it + "] in Green. It is already colored in " + this.verticesColors[it] + ".");
                        } else {
                            System.out.println("Conflict! Cannot color [" + verticeCurrent + "]'s neighbour [" + it + "] in Red. It is already colored in " + this.verticesColors[it] + ".");
                        }
                        System.out.println("\nThis graph is not bipartite!");
                        return;
                    }
                }
            }
            System.out.println("\n" + this.visited + " <- " + this.stack);
            previous = verticeCurrent;
        }
        System.out.println("\nGraph is colored successfully and is bipartite!");
    }

    private boolean recursiveDFS(int verticeCurrent) {
        System.out.println("Current vertice: [" + verticeCurrent + "] - " + this.verticesColors[verticeCurrent]);
        ArrayList<Integer> currentNeighbours = this.adjacencyList.get(verticeCurrent);
        for (Integer it : currentNeighbours) {
            if (this.verticesColors[it] == "Not colored") {
                if (this.verticesColors[verticeCurrent] == "Red") {
                    this.verticesColors[it] = "Green";
                    System.out.println("Coloring [" + it + "] in Green.");
                } else {
                    this.verticesColors[it] = "Red";
                    System.out.println("Coloring [" + it + "] in Red.");
                }
                recursiveDFS(it);
            } else if (this.verticesColors[verticeCurrent] == this.verticesColors[it]) {
                if (this.verticesColors[verticeCurrent] == "Red") {
                    System.out.println("Conflict! Cannot color [" + it + "] in Green. It is already colored in " + this.verticesColors[it] + ".");
                } else {
                    System.out.println("Conflict! Cannot color [" + it + "] in Red. It is already colored in " + this.verticesColors[it] + ".");
                }
                return false;
            }
        }
        System.out.println("\n");
        return true;
    }

    public void displayColors() {
        System.out.println("Displaying colors: ");
        for (int i = 1; i < this.verticesColors.length; ++i) {
            System.out.println("[" + i + "] - " + this.verticesColors[i]);
        }
        System.out.println("\n");
    }
}
