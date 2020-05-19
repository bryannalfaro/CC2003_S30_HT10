/**
 * 
 * @author Bryann
 *Implementacion extraida de: 
 */

public class Edge {
    private Node NodoOrigen;
    private Node NodoDestino;
    private double distancia;
 
    public Edge(Node origin, Node destination, double distance) {
        this.NodoOrigen = origin;
        this.NodoDestino = destination;
        this.distancia = distance;
    }
 
    public Node getOrigin() {
        return NodoOrigen;
    }
 
    public void setOrigin(Node origin) {
        this.NodoOrigen = origin;
    }
 
    public Node getDestination() {
        return NodoDestino;
    }
 
    public void setDestination(Node destination) {
        this.NodoDestino = destination;
    }
 
    public double getDistance() {
        return distancia;
    }
 
    public void setDistance(double distance) {
        this.distancia = distance;
    }
 
    @Override
    public String toString() {
        return "Origen: " + NodoOrigen.getDepartamento() + "\n"+"Destino: "+ NodoDestino.getDepartamento() +"\n"+ "Distancia: "
                + distancia+" km";
    }
 
}
