import java.util.ArrayList;
import java.util.List;
 
/**
 * @author Bryann Alfaro
 * Implementacion extraida de: https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 *
 */
public class Graph {
	
	//Variables a utilizar
	int [][] grafo;
    private List<Node> nodosGrafo;
 
    /**
     * 
     * @param node
     * Metodo que se encarga de agregar un nodo al grafo
     */
    public void agregarNodo(Node node) {
        if (nodosGrafo == null) {
            nodosGrafo = new ArrayList<>();
        }
        nodosGrafo.add(node);
    }
    /**
     * 
     * @return List
     * Metodo que devuelve los nodos en el grafo
     */
    public List<Node> getNodos() {
        return nodosGrafo;
    }
    
    /**
     * 
     * @param n
     * @param indice
     * @return Arista
     * Metodo que devuelve una arista especifica
     */
    public Edge getArista(Node n, int indice) {
    	Edge arista=n.getAristas().get(indice);
    	return arista;
    }
    
    /**
     * 
     * @param index
     * @return Node
     * Metodo que devuelve un nodo especifico
     */
    public Node getNodo(int index) {
    	Node n= getNodos().get(index);
    	return n;
    }
    
    /**
     * 
     * @return matriz
     * Metodo que devuelve el grafo
     */
    public int[][] getGrafo() {
    	this.grafo= new int[getNodos().size()][getNodos().size()];
		return this.grafo;
	}
    
    /**
     * Metodo para imprimir
     */
    @Override
    public String toString() {
        return nodosGrafo + "\n";
    }
 
}