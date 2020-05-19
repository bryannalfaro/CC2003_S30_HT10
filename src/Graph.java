import java.util.ArrayList;
import java.util.List;
 
/**
 * @author Bryann Alfaro
 * Implementacion extraida de: https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 *
 */
public class Graph {
	
	int [][] grafo;
	
    private List<Node> nodosGrafo;
 
    public void agregarNodo(Node node) {
        if (nodosGrafo == null) {
            nodosGrafo = new ArrayList<>();
        }
        nodosGrafo.add(node);
    }
 
    public List<Node> getNodos() {
        return nodosGrafo;
    }
    
    public int[][] getGrafo() {
    	this.grafo= new int[getNodos().size()][getNodos().size()];
		return this.grafo;
	}
 
    @Override
    public String toString() {
        return nodosGrafo + "\n";
    }
 
}