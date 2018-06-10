package grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PruebaGrafoMatriz {

    /**
     * Programa de Prueba: 
     *  1. Lee de un archivo la cantidad de nodos y los arcos
     * del grafo (el nombre del archivo viene como parametro de linea de
     * comandos, sino se asume un nombre por defecto llamado "grafo.txt"
     * ubicado en C:\tmp); 
     *  2. Construye el grafo; 
     *  3. Ejecuta algunos algoritmos de ejemplo
     *
     * El archivo de datos es una secuencia de filas con el formato: 
     *   NodoOrigen NodoDestino Costo
     */
    public static void main(String[] args) {        
        try {
            GrafoMatriz g = null;
            
            String nombreArchivo = "C:\\tmp\\grafo.txt";
            //String nombreArchivo = "C:\\tmp\\grafo-con-ciclo.txt";
            //String nombreArchivo = "C:\\tmp\\grafo-dijkstra.txt";
            //String nombreArchivo = "C:\\tmp\\grafo-con-ciclo.txt";
            if (args != null && (args.length > 0) && args[0] != null && args[0].trim().length() > 0) {
                nombreArchivo = args[0].trim();
            }
                        
            FileReader fin = new FileReader(nombreArchivo);
            BufferedReader archivoGrafo = new BufferedReader(fin);

            //Lee el tamano del grafo
            String linea;
            linea = archivoGrafo.readLine();
            if (linea != null) {
                
                int tamano = Integer.parseInt(linea);
                g = new GrafoMatriz(tamano);
                
                //en las siguientes lineas estan los arcos
                while ((linea = archivoGrafo.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea);
                    if (st.countTokens() != 3) {
                        System.out.println("Linea no cumple formato NodoOrigen NodoDestino Costo : " + linea);
                        continue;
                    }
                    
                    int orig = Integer.parseInt(st.nextToken());
                    int dest = Integer.parseInt(st.nextToken());
                    int costo = Integer.parseInt(st.nextToken());
                    g.agregarArco(orig, dest, costo);
                }
            }
            
            System.out.println("Archivo del grafo leido exitosamente! El grafo se encuentra en memoria.");
            
            System.out.println("El grafo tiene " + g.getCantidadVertices() + " vertice(s) y " + g.getCantidadArcos() + " arco(s).");
            
            g.imprimirMatrizGrafo();
                       
            g.recorridoEnProfundidad();
            
            g.recorridoEnAmplitud();
            
            System.out.println("Grado de Entrada de 0 es " + g.getGradoEntrada(0));
            
            System.out.println("Grado de Salida de 0 es " + g.getGradoSalida(0));
            
            g.ordenacionTopologica();            
            
            g.dijkstra(0);            
            
//            g.calcularMSTPrim();
//            
//            GrafoMatriz kruskal = g.calcularMSTKruskal();
//            System.out.print("\n\nMST calculado con el Algoritmo de Kruskal:\n\t");
//            kruskal.imprimirMatrizGrafo();
            
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
