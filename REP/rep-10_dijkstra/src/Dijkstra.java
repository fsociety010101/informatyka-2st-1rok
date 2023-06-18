import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public int[] dijkstra(ArrayList<ArrayList<Node>> graph, int size, int source) {
        int[] distance = new int[size];
        for (int i = 0; i < size; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((v1, v2) -> v1.compare(v1, v2));
        priorityQueue.add(new Node(source, 0));

        while (priorityQueue.size() > 0) {
            Node current = priorityQueue.poll();

            for (Node n : graph.get(current.id)) {
                if (distance[current.id] + n.cost < distance[n.id]) {
                    distance[n.id] = n.cost + distance[current.id];
                    priorityQueue.add(new Node(n.id, distance[n.id]));
                }
            }
        }

        return distance;
    }
}