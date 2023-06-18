import java.util.Comparator;

public class Node implements Comparator<Node> {
    public int id;
    public int cost;

    public Node(int name, int cost) {
        this.id = name;
        this.cost = cost;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.cost < o2.cost) return -1;
        else if (o1.cost > o2.cost) return 1;
        return 0;

    }

    @Override
    public String toString() {
        return "id = " + id + ", cost = " + cost;
    }
}
