import java.util.ArrayList;
import java.util.List;
 
/**
 * @author Bryann Alfaro
 * Implementacion extraida de: https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 *
 */
public class Node {
	//Variables
    private String departamento;
    private List<Edge> arista;
    
    /**
     * 
     * @param departamento
     * Constructor de nodo
     */
    public Node(String departamento) {
        this.departamento = departamento;
    }
    
    /**
     * 
     * @return departamento
     * Metodo que devuelve el departamento del nodo
     */
    public String getDepartamento() {
        return departamento;
    }
    
    /**
     * 
     * @param departamento
     * Metodo para establecer un departamento  al nodo
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    /**
     * 
     * @return List
     * Metodo que devuelve todas las aristas
     */
    public List<Edge> getAristas() {
        return arista;
    }
    
    /**
     * 
     * @param edge
     * Metodo para agregar una arista al nodo
     */
    public void addArista(Edge aristaNueva) {
        if (arista == null) {
            arista = new ArrayList<>();
        }
        arista.add(aristaNueva);
    }
    
    /**
     * 
     * @param arista
     * Metodo para eliminar una arista al nodo
     */
    public void removeArista(Edge aristaEliminar) {
        arista.remove(aristaEliminar);
    }
 
    /**
     * Metodo para imprimir
     */
    @Override
    public String toString() {
        return arista+"\n";
    }
}
