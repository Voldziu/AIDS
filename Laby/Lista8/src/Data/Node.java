package Data;

public class Node {
    private Vertex destination;
    private int waga;

    public Node(Vertex destination, int waga) {
        this.destination = destination;
        this.waga = waga;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }
}
