/**
 * 
 * @author Bryann
 *Implementacion extraida de: https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
 */

public class Edge {
	//Variables
    private Node NodoOrigen;
    private Node NodoDestino;
    private double distancia;
    
    /**
     * 
     * @param origin
     * @param destination
     * @param distance
     * Constructor de la arista
     */
    public Edge(Node origenNodo, Node destinoNodo, double distanciaNodos) {
        this.NodoOrigen = origenNodo;
        this.NodoDestino = destinoNodo;
        this.distancia = distanciaNodos;
    }
    
    /**
     * Metodo para obtener el origen del grafo
     * @return
     */
    public Node getOrigen() {
        return NodoOrigen;
    }
    
    /**
     * Metodo para settear el origen
     * @param origenNodo
     */
    public void setOrigen(Node origenNodo) {
        this.NodoOrigen = origenNodo;
    }
    
    /**
     * Metodo para obtener el destino 
     * @return
     */
    public Node getDestino() {
        return NodoDestino;
    }
    
    /**
     * Metodo para establecer el destino
     * @param destinoNode
     */
    public void setDestino(Node destinoNode) {
        this.NodoDestino = destinoNode;
    }
    
    /**
     * Metodo para obtener la distancia
     * @return
     */
    public double getDistancia() {
        return distancia;
    }
    
    /**
     * Metodo que establece la distancia
     * @param distanciaArista
     */
    public void setDistancia(double distanciaArista) {
        this.distancia = distanciaArista;
    }
 
    @Override
    public String toString() {
        return "Origen: " + NodoOrigen.getDepartamento() + "\n"+"Destino: "+ NodoDestino.getDepartamento() +"\n"+ "Distancia: "
                + distancia+" km";
    }
 
}
