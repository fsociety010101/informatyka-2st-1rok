import GraphService.GraphBFS;
import GraphService.GraphDFS;
import GraphService.GraphReader;

public class Main {
    public static void main(String[] args) {
        /* BFS */
        System.out.println("------------------ Test 1 - BFS ------------------");
        GraphReader fr_test1 = new GraphReader("./src/files/graphData_test1.txt");
        GraphBFS bfs_test1 = new GraphBFS(fr_test1.getVerticesAmount(), fr_test1.getEdgesAmount(), fr_test1.getAdjacencyList());
        bfs_test1.displayColors();

        System.out.println("------------------ Test 2 - BFS ------------------");
        GraphReader fr_test2 = new GraphReader("./src/files/graphData_test2.txt");
        GraphBFS bfs_test2 = new GraphBFS(fr_test2.getVerticesAmount(), fr_test2.getEdgesAmount(), fr_test2.getAdjacencyList());
        bfs_test2.displayColors();

        System.out.println("------------------ Test 3 - BFS ------------------");
        GraphReader fr_test3 = new GraphReader("./src/files/graphData_test3.txt");
        GraphBFS bfs_test3 = new GraphBFS(fr_test3.getVerticesAmount(), fr_test3.getEdgesAmount(), fr_test3.getAdjacencyList());
        bfs_test3.displayColors();

        /* DFS */
        /* jest rowniez mozliwosc rekurencyjnego wywolania DFS*/
        System.out.println("------------------ Test 1 - DFS ------------------");
        GraphReader fr2_test1 = new GraphReader("./src/files/graphData_test1.txt");
        GraphDFS dfs_test1 = new GraphDFS(fr2_test1.getVerticesAmount(), fr2_test1.getEdgesAmount(), fr2_test1.getAdjacencyList());
        dfs_test1.displayColors();

        System.out.println("------------------ Test 2 - DFS ------------------");
        GraphReader fr2_test2 = new GraphReader("./src/files/graphData_test2.txt");
        GraphDFS dfs_test2 = new GraphDFS(fr2_test2.getVerticesAmount(), fr2_test2.getEdgesAmount(), fr2_test2.getAdjacencyList());
        dfs_test2.displayColors();

        System.out.println("------------------ Test 3 - DFS ------------------");
        GraphReader fr2_test3 = new GraphReader("./src/files/graphData_test3.txt");
        GraphDFS dfs_test3 = new GraphDFS(fr2_test3.getVerticesAmount(), fr2_test3.getEdgesAmount(), fr2_test3.getAdjacencyList());
        dfs_test3.displayColors();
    }
}