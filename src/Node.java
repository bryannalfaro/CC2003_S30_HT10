import java.util.ArrayList;
import java.util.List;
 
/**
 * @author Bryann Alfaro
 * Implementacion extraida de: 
 *
 */
public class Node {
    private String departamento;
    private List<Edge> arista;
 
    public Node(String departamento) {
        this.departamento = departamento;
    }
 
    public String getDepartamento() {
        return departamento;
    }
 
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
 
    public List<Edge> getAristas() {
        return arista;
    }
 
    public void addArista(Edge edge) {
        if (arista == null) {
            arista = new ArrayList<>();
        }
        arista.add(edge);
    }
 
    @Override
    public String toString() {
        return arista+"\n";
    }
}
