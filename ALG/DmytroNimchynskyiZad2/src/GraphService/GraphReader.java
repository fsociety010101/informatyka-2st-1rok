package GraphService;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphReader {
    private File file;
    private Scanner scanner;
    private String line;
    private final String filename;
    int verticesAmount, edgesAmount;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public int getVerticesAmount() {
        return verticesAmount;
    }

    public int getEdgesAmount() {
        return edgesAmount;
    }

    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public GraphReader(String filename) {
        this.filename = filename;
        initGraph();
        readEdges();
    }

    private void initGraph() {
        try {
            // open and read the file
            this.file = new File(filename);
            this.scanner = new Scanner(file);
            this.line = this.scanner.nextLine();

            // read vertices and edges amount and init arraylist
            String[] lineSplit;
            lineSplit = this.line.split(" ");
            this.verticesAmount = Integer.parseInt(lineSplit[0]);
            this.edgesAmount = Integer.parseInt(lineSplit[1]);

            // init adjacencyList, started numbering from 1 but 0 remains
            this.adjacencyList = new ArrayList<ArrayList<Integer>>(this.verticesAmount + 1);
            for (int i = 0; i < this.verticesAmount + 1; i++)
                this.adjacencyList.add(new ArrayList<Integer>());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void readEdges() {
        try {
            // read edges, started numbering from 1 but 0 remains
            String[] lineSplit, edgeSplit;
            this.line = this.scanner.nextLine();
            lineSplit = this.line.split(", ");
            for (int i = 0; i < this.edgesAmount; ++i) {
                edgeSplit = lineSplit[i].split(" ");
                this.adjacencyList.get(Integer.parseInt(edgeSplit[0])).add(Integer.parseInt(edgeSplit[1]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        displayGraph();
    }

    private void displayGraph() {
        System.out.println("Vertices amount: " + this.verticesAmount + "\nEdges amount: " + this.edgesAmount + "\nAdjacency list: ");
        for (int i = 1; i < this.adjacencyList.size(); ++i) {
            System.out.println(i + ": " + this.adjacencyList.get(i));
        }
    }

}
