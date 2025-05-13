import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        Vertex<String> start = new Vertex<>("Almaty");
        Vertex<String> goal = new Vertex<>("Kyzylorda");

        System.out.println("Dijkstra:");
        Search<String> dijkstra = new DijkstraSearch<>(weightedGraph, start);
        outputPath(dijkstra, goal);
        System.out.println("Distance: " + ((DijkstraSearch<String>) dijkstra).getDistanceTo(goal));

        System.out.println("--------------------------------");

        WeightedGraph<String> unweightedGraph = new WeightedGraph<>(true);
        fillWithoutWeights(unweightedGraph);

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(unweightedGraph, start);
        outputPath(bfs, goal);
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 2.1);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 7.8);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 7.1);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 7.2);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 3.9);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 3.5);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 5.4);
    }

    public static void fillWithoutWeights(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 1.0);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 1.0);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 1.0);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 1.0);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 1.0);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 1.0);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 1.0);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        List<Vertex<String>> path = search.getPath(key);
        if (path.isEmpty()) {
            System.out.println("Path not found.");
            return;
        }

        for (Vertex<String> v : path) {
            System.out.print(v.getData() + " -> ");
        }

        System.out.println("end");
    }
}