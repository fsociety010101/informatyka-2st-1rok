package GraphService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphBFS {
    private final int verticesAmount, edgesAmount;
    private final ArrayList<ArrayList<Integer>> adjacencyList;
    private String[] verticesColors;
    private LinkedList<Integer> queue;
    private LinkedList<Integer> visited;

    public GraphBFS(int verticesAmount, int edgesAmount, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.verticesAmount = verticesAmount;
        this.edgesAmount = edgesAmount;
        this.adjacencyList = adjacencyList;
        this.verticesColors = new String[this.verticesAmount + 1]; // +1 bc starting from vertice n1
        Arrays.fill(verticesColors, "Not colored");
        this.queue = new LinkedList<>();
        this.visited = new LinkedList<>();

        bipartiteBFS(1);
    }

    private void bipartiteBFS(int verticeCurrent) {
        System.out.println("\n*** Checking if graph is bipartite using BFS... ***\n");

        // mark 1 as visited(colored) and add to queue
        System.out.println("Start vertice is [1]. Coloring [1] in Red.");
        this.verticesColors[verticeCurrent] = "Red";
        this.queue.add(verticeCurrent);

        // iterate through all vertices, mark as visited and add to queue until queue.size == 0
        while (this.queue.size() != 0) {
            // get and remove head vertice from queue
            verticeCurrent = queue.poll();
            this.visited.add(verticeCurrent); // to display visited vertices in terminal
            System.out.println("Current vertice: [" + verticeCurrent + "] - " + this.verticesColors[verticeCurrent]);

            // get list of all neighbours for current vertice and iterate through it
            ArrayList<Integer> currentNeighbours = this.adjacencyList.get(verticeCurrent);
            for (Integer it : currentNeighbours) {
                // check if ntow visited (== not colored)
                if (this.verticesColors[it] == "Not colored") {
                    if (this.verticesColors[verticeCurrent] == "Red") {
                        this.verticesColors[it] = "Green";
                        System.out.println("Coloring [" + it + "] in Green.");
                    } else {
                        this.verticesColors[it] = "Red";
                        System.out.println("Coloring [" + it + "] in Red.");
                    }
                    this.queue.add(it);

                    // neighbour vertice already has the same color as current vertice
                } else if (this.verticesColors[verticeCurrent] == this.verticesColors[it]) {
                    if (this.verticesColors[verticeCurrent] == "Red") {
                        System.out.println("Conflict! Cannot color [" + it + "] in Green. It is already colored in " + this.verticesColors[it] + ".");
                    } else {
                        System.out.println("Conflict! Cannot color [" + it + "] in Red. It is already colored in " + this.verticesColors[it] + ".");
                    }
                    System.out.println("\nThis graph is not bipartite!");
                    return;
                }
            }
            System.out.println(this.visited + " <- " + this.queue + "\n");
        }
        System.out.println("\nGraph is colored successfully and is bipartite!");
    }

    public void displayColors() {
        System.out.println("Displaying colors: ");
        for (int i = 1; i < this.verticesColors.length; ++i) {
            System.out.println("[" + i + "] - " + this.verticesColors[i]);
        }
        System.out.println("\n");
    }
}