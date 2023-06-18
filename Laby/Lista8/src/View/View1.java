package View;

import Controler.ControlerWezly;
import Data.GraphData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View1 {
    private final int WINDOW_WIDTH = 2000;
    private final int WINDOW_HEIGHT = 3000;
    private static JFrame frame;
    private JPanel north;
    private JPanel north2;
    private JPanel NORTH;
    private JPanel startkoniec;
    private  JPanel northprzyciski;
    private static  GraphPanel centre;
    private JLabel podajwierzcholki;
    private JLabel podajstart;
    private JLabel podajkoniec;
    private JButton zwyklygraph;
    private JButton gg;
    private JButton rng;
    private JButton zatwierdzDijkstra;
    private JTextField wierzcholki;
    private JTextField start;
    private JTextField koniec;




    public  View1(){
        frame =new JFrame("Witaj w Novigradzie");
        podajwierzcholki= new JLabel("Podaj liczbę wierzchołków [1.10]---->");
        podajstart = new JLabel("Podaj label wierzchołka startowego");
        podajkoniec = new JLabel("Podaj label wierzchołka końcowego");
        wierzcholki = new JTextField(15);
        start = new JTextField(15);
        koniec = new JTextField(15);
        north = new JPanel();
        north2 = new JPanel();
        northprzyciski = new JPanel();

        north2.setVisible(false);
        NORTH = new JPanel();
        centre = new GraphPanel();
        zwyklygraph = new JButton("Stworz zwykly graph");
        gg = new JButton("Stworz Gabriels Graph");
        rng = new JButton("Stworz RNG");
        zatwierdzDijkstra = new JButton("Wykonaj algortym Dijkstry");





    }
    public void GUI_Create(){
        frame.getContentPane().add(BorderLayout.CENTER,centre);
        frame.getContentPane().add(BorderLayout.NORTH,NORTH);


        NORTH.add(BorderLayout.NORTH,north);
        NORTH.add(BorderLayout.SOUTH,north2);
        northprzyciski.setLayout(new GridLayout(3,1));
        north.setLayout(new GridLayout(1,3));
        north.add(podajwierzcholki);
        north.add(wierzcholki);
        north.add(northprzyciski);
        northprzyciski.add(zwyklygraph);
        northprzyciski.add(gg);
        northprzyciski.add(rng);


        north2.setLayout(new GridLayout(2,3));
        north2.add(podajstart);
        north2.add(start);
        north2.add(zatwierdzDijkstra);
        north2.add(podajkoniec);
        north2.add(koniec);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);





    }
    class ZatwierdzWierzcholki implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlerWezly.setWezlyFromView(Integer.parseInt(wierzcholki.getText()));

        }
    }
    class ZatwierzDijkstra implements ActionListener{
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static  void setData(GraphData data){
        centre.setData(data);
        frame.repaint();
    }
    public static GraphData getData(){
        return centre.getData();
    }

}
