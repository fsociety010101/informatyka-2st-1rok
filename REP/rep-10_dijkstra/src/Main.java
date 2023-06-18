import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 9;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < size; ++i)
            graph.add(new ArrayList<>());

        Random random = new Random();
        graph.get(0).add(new Node(1, random.nextInt(20)));
        graph.get(0).add(new Node(7, random.nextInt(20)));
        graph.get(1).add(new Node(2, random.nextInt(20)));
        graph.get(1).add(new Node(7, random.nextInt(20)));
        graph.get(1).add(new Node(0, random.nextInt(20)));
        graph.get(2).add(new Node(1, random.nextInt(20)));
        graph.get(2).add(new Node(3, random.nextInt(20)));
        graph.get(2).add(new Node(8, random.nextInt(20)));
        graph.get(2).add(new Node(5, random.nextInt(20)));
        graph.get(3).add(new Node(2, random.nextInt(20)));
        graph.get(3).add(new Node(4, random.nextInt(20)));
        graph.get(3).add(new Node(5, random.nextInt(20)));
        graph.get(4).add(new Node(3, random.nextInt(20)));
        graph.get(4).add(new Node(5, random.nextInt(20)));
        graph.get(5).add(new Node(4, random.nextInt(20)));
        graph.get(5).add(new Node(6, random.nextInt(20)));
        graph.get(6).add(new Node(5, random.nextInt(20)));
        graph.get(6).add(new Node(7, random.nextInt(20)));
        graph.get(6).add(new Node(8, random.nextInt(20)));
        graph.get(7).add(new Node(0, random.nextInt(20)));
        graph.get(7).add(new Node(1, random.nextInt(20)));
        graph.get(7).add(new Node(6, random.nextInt(20)));
        graph.get(7).add(new Node(8, random.nextInt(20)));
        graph.get(8).add(new Node(2, random.nextInt(20)));
        graph.get(8).add(new Node(6, random.nextInt(20)));
        graph.get(8).add(new Node(7, random.nextInt(20)));

        Dijkstra dijkstraClass = new Dijkstra();
        int[] distance = dijkstraClass.dijkstra(graph, size, 0);

        System.out.println("Node  " + "  Distance from Source");
        for (int i = 0; i < size; i++)
            System.out.println(i + "             " + distance[i]);

    }
}