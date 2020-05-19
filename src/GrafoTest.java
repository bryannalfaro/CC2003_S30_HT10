/**
 * @author Bryann Alfaro
 * Clase donde se realizan las pruebas
 * unitarias para los metodos del grafo
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {
	
	/**
	 * Prueba para agregar un nodo al grafo
	 */
	@Test
	public void AgregarNodotest() {
		Graph grafoPrueba=new Graph();
		Node n = new Node("Guatemala");
		Node n2 = new Node("Peten");
		
		n.addArista(new Edge(n,n2,4.56));
		n2.addArista(new Edge(n2,n,4.56));
		
		grafoPrueba.agregarNodo(n);
		grafoPrueba.agregarNodo(n2);
		assertEquals("Guatemala",n.getDepartamento());
	}
	
	/**
	 * Prueba para agregar una arista al grafo
	 */
	
	@Test
	public void AgregarAristatest() {
		Graph grafoPrueba=new Graph();
		Node n = new Node("Guatemala");
		Node n2 = new Node("Peten");
		
		n.addArista(new Edge(n,n2,4.56));
		n2.addArista(new Edge(n2,n,4.56));
		
		grafoPrueba.agregarNodo(n);
		grafoPrueba.agregarNodo(n2);
		
		double distanciaNodos= n.getAristas().get(0).getDistancia();
		String distancia= Double.toString(distanciaNodos);
		
		assertEquals("4.56", distancia);
		
	}
	
	/**
	 * Prueba para eliminar un nodo del grafo
	 */
	@Test
	public void EliminarNodotest() {
		Graph grafoPrueba=new Graph();
		Node n = new Node("Guatemala");
		Node n2 = new Node("Peten");
		
		n.addArista(new Edge(n,n2,4.56));
		n2.addArista(new Edge(n2,n,4.56));
		
		grafoPrueba.agregarNodo(n);
		grafoPrueba.agregarNodo(n2);
		
		grafoPrueba.removeNodo(n);
		int longitudNodos= grafoPrueba.getNodos().size();
		assertEquals(1,longitudNodos); //porque solo habra 1 nodo, en lugar de 2
	}
	
	/**
	 * Prueba para manipular una arista
	 */
	@Test
	public void EditarAristatest() {
		Graph grafoPrueba=new Graph();
		Node n = new Node("Guatemala");
		Node n2 = new Node("Peten");
		
		n.addArista(new Edge(n,n2,4.56));
		n2.addArista(new Edge(n2,n,4.56));
		
		grafoPrueba.agregarNodo(n);
		grafoPrueba.agregarNodo(n2);
		
		n.getAristas().get(0).setDistancia(8.69);
		double distanciaNodos= n.getAristas().get(0).getDistancia();
		String distancia= Double.toString(distanciaNodos);
		assertEquals("8.69",distancia);
	}

}
