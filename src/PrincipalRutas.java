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
		try {
			String directorioNuevoDiccionario = System.getProperty("user.dir");
	        Scanner inputScan = new Scanner(new File(directorioNuevoDiccionario + "\\src\\guategrafo.txt"));
	        
	        while (inputScan.hasNextLine()) {
	            String line = inputScan.nextLine();
	            String[] indice_particion_texto = line.split(" "); //Particionar texto
	            
	            String primera_parte = indice_particion_texto[0];
	            String segunda_parte = indice_particion_texto[1];
	            String tercera_parte = indice_particion_texto[2];
	           
	            Node n = new Node(primera_parte);
	            Node n2 = new Node(segunda_parte);
	            n.addArista(new Edge(n,n2,Double.parseDouble(tercera_parte)));
	            grafo2.agregarNodo(n);
	            
	        }
	        inputScan.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
    	
	 List<Node> lista =grafo2.getNodos();
	 for(int i=0; i<lista.size();i++) {
		 System.out.println("****************************************");
		 System.out.println(lista.get(i).getAristas().get(0).toString());
		 System.out.println("****************************************");
		 System.out.println();
	 }
	 
		
    }
}
