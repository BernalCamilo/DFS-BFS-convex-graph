package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph{
    private int totalNodos;
    private final HashMap<String, Nodo<String>> nodoHashMap = new HashMap<>();
    private ArrayList<String> nodoValues;


    public Graph(int totalNodos) {
        this.totalNodos = totalNodos;
    }

    public boolean fuertementeC (){
        boolean v = true;
        for (int i = 0; i < nodoValues.size() && v; i++) {
            toFalse();
            dfs(nodoHashMap.get(nodoValues.get(i)));
            if (!searchFalse()){
                v = false;
            }
        }
        return v;
    }

    public void bfs(String value){

    }

    public void toFalse(){
        for (int i = 0; i < totalNodos; i++) {
            nodoHashMap.get(nodoValues.get(i)).setVisited(false);
        }
    }

    /*
    si es true, todos los campos fueron visitados.
    si es false, al menos un nodo no fue visitado
     */
    public boolean searchFalse(){
        boolean v = true;
        for (int i = 0; i < nodoValues.size() && v; i++) {
            if (!nodoHashMap.get(nodoValues.get(i)).isVisited()){
                v = false;
            }
        }
        return v;
    }

    public void dfs(Nodo<String> nd){
        nd.setVisited(true);
        for (int i = 0; i < nd.getConec().size(); i++) {
            Nodo<String> nextNodo = nd.getConec().get(i);
            if (!nextNodo.isVisited()){
                dfs(nextNodo);
            }
        }
    }

    public void addNodo(String value){
        nodoHashMap.put(value, new Nodo<String>(value));
    }

    public void addConection(String value, ArrayList<String> conec){
        Nodo<String> nd = nodoHashMap.get(value);
        ArrayList<Nodo<String>> nodosToConec = new ArrayList<>();
        for (int i = 0; i < conec.size(); i++) {
            Nodo<String> nodo = nodoHashMap.get(conec.get(i));
            nodosToConec.add(nodoHashMap.get(conec.get(i)));
        }
        nd.setConec(nodosToConec);
    }

    public void setNodoValues(ArrayList<String> nodoValues) {
        this.nodoValues = nodoValues;
    }
}