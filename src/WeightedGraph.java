import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices;

    public WeightedGraph(boolean b){
        this.vertices = new HashSet<>();
    }
    public void addVertex (Vertex<T> vertex){
        vertices.add(vertex);
    }
    public void addEdge(Vertex<T> from, Vertex<T> to, double weight) {
        if (!vertices.contains(from)) {
            addVertex(from);
        }
        if (!vertices.contains(to)) {
            addVertex(to);
        }
        from.addAdjacentVertex(to, weight);
    }
    public Set<Vertex<T>> getVertices(){
        return vertices;
    }
    public Vertex<T> getVertexByData(T data){
        for(Vertex<T> vertex : vertices){
            if(vertex.getData().equals(data)){
                return vertex;
            }
        }
        return null;
    }
}
