import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T>{
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        this.adjacentVertices = new HashMap<Vertex<T>, Double>();
    }
    public T getData(){
        return this.data;
    }
    public Map<Vertex<T>, Double> getAdjacentVertices(){
        return this.adjacentVertices;
    }
    public void addAdjacentVertex(Vertex<T> destination, Double weight ){
        adjacentVertices.put(destination, weight);
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
    public int hashCode(){
        return Objects.hash(data);
    }
}
