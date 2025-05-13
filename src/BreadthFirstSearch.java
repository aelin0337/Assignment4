import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> startVertex) {
        super(startVertex);

        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()){
            Vertex<T> current = queue.poll();

            for(Vertex<T> neighbor : current.getAdjacentVertices().keySet()){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
