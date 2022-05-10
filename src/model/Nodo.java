package model;

import java.util.ArrayList;

public class Nodo<T> {
    //Atrin¿butos
    private T value;
    private boolean visited;
    private ArrayList<Nodo<T>> conec;

    public Nodo(T value) {
        this.value = value;
        this.visited = false;
        this.conec = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Nodo<T>> getConec() {
        return conec;
    }

    public void setConec(ArrayList<Nodo<T>> conec) {
        this.conec = conec;
    }
}
