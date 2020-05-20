/**
 * Implementacion extraida de: https://www.jc-mouse.net/java/matriz-de-adyacencia-representacion-de-grafos-en-java
 * @author Bryann
 *
 */
public class MatrizArmado {
    
	//Variables
    private int cantidadNodos;
    private int[][] matrizAdyacencia;
    
    /**
     * Constructor de la matriz
     * @param cantidad 
     */
    public MatrizArmado(int cantidad) {
        this.cantidadNodos = cantidad;
        matrizAdyacencia = new int[cantidadNodos][cantidadNodos];
        //Cargar matriz con valores vacios
        for(int i=0; i< cantidad; i++){
            for(int j=0; j< cantidad; j++){
                matrizAdyacencia[i][j] = 0;
            }            
        }
    }
    /**
     * Metodo para obtener a la matriz
     * @return
     */
    public int [][] getMatriz() {
    	return this.matrizAdyacencia;
    }
    
    /**
     * Metodo para agregar elementos a la matriz con peso
     * @param pos1
     * @param pos2
     * @param peso
     */
    public void insertarPeso(int pos1, int pos2, double peso){
        matrizAdyacencia[pos1][pos2] += peso;
    }
    
    /**
     * Metodo para mostrar en pantalla la matriz
     */
    public void mostrarMatriz(){
        for(int i=0; i< cantidadNodos; i++){
            for(int j=0; j< cantidadNodos; j++){
                System.out.print( matrizAdyacencia[i][j] + "-" );        
            }
            System.out.println();
        }  
    }
}
