package Data;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphData {
    private ArrayList<Vertex> vertecies;
    private  ArrayList<Edge> edges;
    private HashMap<Vertex,ArrayList<Node>> matrix;

    public GraphData(ArrayList<Vertex> vertecies, ArrayList<Edge> edges, HashMap<Vertex, ArrayList<Node>> matrix) {
        this.vertecies = vertecies;
        this.edges = edges;
        this.matrix = matrix;
    }

    public ArrayList<Vertex> getVertecies() {
        return vertecies;
    }

    public void setVertecies(ArrayList<Vertex> vertecies) {
        this.vertecies = vertecies;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public HashMap<Vertex, ArrayList<Node>> getMatrix() {
        return matrix;
    }

    public void setMatrix(HashMap<Vertex, ArrayList<Node>> matrix) {
        this.matrix = matrix;
    }
}
