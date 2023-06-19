package View;

import javax.swing.*;
import Data.*;

import java.awt.*;

public class GraphPanel extends JPanel {

    private  GraphData data;
    private final int xdim=200;
    private final int ydim = 300;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data!=null){
            for (Vertex vertex : data.getVertecies()) {
                int x = vertex.getX();
                int y = vertex.getY();
                g.setColor(Color.BLUE);
                g.fillOval(x - 20, y - 20, 40, 40);
                g.setColor(Color.WHITE);
                g.drawString(vertex.getLabel(), x - 15, y);
            }

            // Rysowanie krawędzi

            for (Edge edge : data.getEdges()) {
                int x1 = edge.getSource().getX();
                int y1 = edge.getSource().getY();
                int x2 = edge.getTarget().getX();
                int y2 = edge.getTarget().getY();

                if(edge.isColor()){
                    g.setColor(Color.RED);
                } else{
                    g.setColor(Color.BLACK);
                }
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.ORANGE);
                Font font = new Font("Arial",Font.BOLD,24);
                g.setFont(font);
                g.drawString(String.valueOf(edge.getWaga()),(x1+x2)/2,(y1+y2)/2);

            }
        }

        // Rysowanie wierzchołków


    }

    public GraphData getData() {
        return data;
    }

    public void setData(GraphData data) {
        this.data = data;
    }
}
