package Data;

import java.security.spec.RSAOtherPrimeInfo;

public class Edge {
    private Vertex source;
    private Vertex target;

    private int waga;
    private boolean color;

    public Edge(Vertex source, Vertex target,int waga) {
        this.source = source;
        this.target = target;
        this.waga=waga;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Edge){

            boolean returnvalue= ((Edge) obj).getSource() == this.getSource() && (((Edge) obj).getTarget() == this.getTarget());
            if(returnvalue){
                System.out.println("true");

            } else{
                System.out.println("false");
            }
            return returnvalue;

        } else{

            return false;
        }

    }

    @Override
    public String toString() {
        return source.getLabel()+target.getLabel()+String.valueOf(waga);
    }
}
