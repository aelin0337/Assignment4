import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<T> extends Search<T> {

    private final Map<Vertex<T>, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> startVertex) {
        super(startVertex);

        for (Vertex<T> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);

        PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get)
        );
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<T> current = priorityQueue.poll();

            for (Map.Entry<Vertex<T>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double currentDistance = distances.get(current);
                double newDistance = currentDistance + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    parentMap.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }
    }
    public double getDistanceTo(Vertex<T> vertex) {
        return distances.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
}
