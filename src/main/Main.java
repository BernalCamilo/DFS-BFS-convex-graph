package main;

import model.Graph;

import java.util.*;


public class Main {
    public static Scanner lec = new Scanner(System.in);
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static HashMap<Integer, Boolean> mapVisited = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Cuantos nodos desea ingresar?");
        int totalNodos = lec.nextInt();
        lec.nextLine();
        ArrayList<String> values = new ArrayList<>();
        Graph graph = new Graph(totalNodos);
        for (int i = 0; i < totalNodos; i++) {
            System.out.println("ingrese el valor del nodo numero: " + (i + 1));
            String value = lec.nextLine();
            values.add(value);
            graph.addNodo(value);
        }
        graph.setNodoValues(values);
        for (int i = 0; i < totalNodos; i++) {
            System.out.println("ingrese las coneciones para el nodo con el valor: " + values.get(i) + " separadas con un espacio cada una");
            String conectionsString = lec.nextLine();
            String[] conection = conectionsString.split(" ");
            ArrayList<String> v = new ArrayList<>();
            for (int j = 0; j < conection.length; j++) {
                v.add(conection[j]);
            }
            graph.addConection(values.get(i), v);
        }
        if (graph.fuertementeC()){
            System.out.println("El grafo es conexo");
        } else {
            System.out.println("El grafo no es conexo");
        }
    }
}
