import java.util.*;

public abstract class Search <T>{
    protected final Vertex<T> startVertex;
    protected final Map<Vertex<T>, Vertex<T>> parentMap = new HashMap<>();

    public Search(Vertex<T> startVertex){
        this.startVertex = startVertex;
    }
    public List<Vertex<T>> getPath(Vertex<T> destination){
        List<Vertex<T>> path = new ArrayList<>();
        Vertex<T> current = destination;

        while(current != null){
            path.add(current);
            current = parentMap.get(current);
        }
        if (current == null){
            return Collections.emptyList();
        }

        path.add(startVertex);
        return path;
    }
}
