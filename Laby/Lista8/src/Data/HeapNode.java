package Data;

public class HeapNode implements Comparable<HeapNode>{
    private Vertex destination;
    private int waga;
    private Vertex previous;

    public HeapNode(Vertex destination, int waga) {
        this.destination = destination;
        this.waga = waga;
    }
    public int compareTo(HeapNode node){
        return Integer.compare(this.waga,node.waga);
    }
    public Vertex getPrevious(){
        return previous;
    }
    public void setPrevious(Vertex previous){
        this.previous=previous;
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
