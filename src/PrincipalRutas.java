import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bryann Alfaro
 * Programa principal para grafo
 *
 */
public class PrincipalRutas {
 
 
    public static void main(String[] args) {
    	
        Graph grafo2 = new Graph();
    	System.out.println("---ARMADO DEL GRAFO ----");
    	String directorioNuevoDiccionario = System.getProperty("user.dir");
        Scanner inputScan;
		try {
			
	        
	        if(directorioNuevoDiccionario.contains("src")) {
            	inputScan = new Scanner(new File(directorioNuevoDiccionario + "\\src\\guategrafo.txt"));
            }else {
            	inputScan = new Scanner(new File(directorioNuevoDiccionario + "\\src\\guategrafo.txt"));
            }
	        
	        
	        int contador=0;
	        while (inputScan.hasNextLine()) {
	            String line = inputScan.nextLine();
	            String[] indice_particion_texto = line.split(" "); //Particionar texto
	            
	            String primera_parte = indice_particion_texto[0];//Obtiene origen
	            String segunda_parte = indice_particion_texto[1];//Obtiene destino
	            String tercera_parte = indice_particion_texto[2];//Obtiene distancia
	            
	            if(contador>=4) {
	        	   if(primera_parte.equals("Peten")) {
	        		   
		            	Node n = grafo2.getNodos().get(2);
		            	
			            Node n2 = new Node(segunda_parte);
			            n.addArista(new Edge(n,n2,Double.parseDouble(tercera_parte)));
		            }else 
		            {
		            	Node n = new Node(primera_parte);
			            
			            Node n2 = new Node(segunda_parte);
			            n.addArista(new Edge(n,n2,Double.parseDouble(tercera_parte)));
			            grafo2.agregarNodo(n);
		            }
	           }else {
	        	   Node n = new Node(primera_parte);
		            
		            Node n2 = new Node(segunda_parte);
		            n.addArista(new Edge(n,n2,Double.parseDouble(tercera_parte)));
		            grafo2.agregarNodo(n);
	           }
	           contador++;
	            
	            
	        }
	        inputScan.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		
		
    //Se obtiene la lista de nodos
	 List<Node> lista =grafo2.getNodos();
	 MatrizArmado matriz = new MatrizArmado(lista.size());
	 
	 //Armar la matriz de adyacencia tomando en cuenta cantidad de aristas y pesos
	 for(int i=0; i<(grafo2.getNodos().size());i++) {
		 for(int j=0; j<(grafo2.getNodos().size());j++) {
			 if(grafo2.getNodos().get(i).getAristas().size()>1) {
				 if(grafo2.getNodos().get(i).getAristas().get(0).getDestino().getDepartamento().equals(grafo2.getNodo(j).getDepartamento())){
					 matriz.insertarPeso(grafo2.getNodos().indexOf(grafo2.getNodo(i)), grafo2.getNodos().indexOf(grafo2.getNodo(j)), grafo2.getNodos().get(i).getAristas().get(0).getDistancia());
				 }else if(grafo2.getNodos().get(i).getAristas().get(1).getDestino().getDepartamento().equals(grafo2.getNodo(j).getDepartamento())){
					 matriz.insertarPeso(grafo2.getNodos().indexOf(grafo2.getNodo(i)), grafo2.getNodos().indexOf(grafo2.getNodo(j)), grafo2.getNodos().get(i).getAristas().get(1).getDistancia());
				 }
				 
				 else {
					 matriz.insertarPeso(grafo2.getNodos().indexOf(grafo2.getNodo(i)), grafo2.getNodos().indexOf(grafo2.getNodo(j)), 999999);
				 } 
			 }else {
				 if(grafo2.getNodos().get(i).getAristas().get(0).getDestino().getDepartamento().equals(grafo2.getNodo(j).getDepartamento())){
					 matriz.insertarPeso(grafo2.getNodos().indexOf(grafo2.getNodo(i)), grafo2.getNodos().indexOf(grafo2.getNodo(j)), grafo2.getNodos().get(i).getAristas().get(0).getDistancia());
				 }else {
					 matriz.insertarPeso(grafo2.getNodos().indexOf(grafo2.getNodo(i)), grafo2.getNodos().indexOf(grafo2.getNodo(j)), 999999);
				 }
			 }
			 
			 
		 }
	 }
	
	 
	 for(int i=0; i<lista.size();i++) {
		 System.out.println("****************************************");
		 if(lista.get(i).getAristas().size()==2) {
			 System.out.println(lista.get(i).getAristas().get(0).toString());
			 System.out.println(lista.get(i).getAristas().get(1).toString());
		 }else {
			 System.out.println(lista.get(i).getAristas().get(0).toString());
		 }
		 
		 System.out.println("****************************************");
		 System.out.println();
	 }
	 System.out.println();
	 System.out.println("-------MATRIZ DE ADYACENCIA DEL GRAFO-----------");
	 matriz.mostrarMatriz();
	 MatrizArmado m = new MatrizArmado(2);
	 
	 System.out.println();
	 
	 
	 
	 	
    }
}
