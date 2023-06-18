package Data;

public class Vertex {
    private String label;
    private int x;
    private int y;


    public Vertex(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
