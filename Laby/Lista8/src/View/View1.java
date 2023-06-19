package View;

import Algs.Cyklomierz;
import Controler.ControlerStartKoniec;
import Controler.ControlerWezly;
import Data.GraphData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View1 {
    private final int WINDOW_WIDTH = 3000;
    private final int WINDOW_HEIGHT = 3000;
    private static JFrame frame;
    private JPanel north;
    private JPanel north2;
    private JPanel NORTH;
    private static JPanel east;
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
    private JButton cykle;
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
        east = new JPanel();

        northprzyciski = new JPanel();

        north2.setVisible(false);
        NORTH = new JPanel();
        centre = new GraphPanel();
        zwyklygraph = new JButton("Stworz zwykly graph");
        gg = new JButton("Stworz Gabriels Graph");
        rng = new JButton("Stworz RNG");
        zatwierdzDijkstra = new JButton("Wykonaj algortym Dijkstry");
        cykle = new JButton("Wypisz wszystkie cykle");





    }
    public void GUI_Create(){
        frame.getContentPane().add(BorderLayout.CENTER,centre);
        frame.getContentPane().add(BorderLayout.NORTH,NORTH);
        frame.getContentPane().add(BorderLayout.EAST,east);


        NORTH.add(BorderLayout.NORTH,north);
        NORTH.add(BorderLayout.SOUTH,north2);
        NORTH.setPreferredSize(new Dimension(1000,200));
        northprzyciski.setLayout(new GridLayout(3,1));
        north.setLayout(new GridLayout(1,3));
        north.add(podajwierzcholki);
        north.add(wierzcholki);
        north.add(northprzyciski);
        centre.setPreferredSize(new Dimension(1000,1000));
        northprzyciski.add(zwyklygraph);
        northprzyciski.add(gg);
        northprzyciski.add(rng);


        north2.setLayout(new GridLayout(2,3));
        north2.add(podajstart);
        north2.add(start);
        north2.add(zatwierdzDijkstra);
        north2.add(podajkoniec);
        north2.add(koniec);
        north2.add(cykle);
        zwyklygraph.addActionListener(new Zwykly());
        gg.addActionListener(new GG());
        rng.addActionListener(new RNG());
        cykle.addActionListener(new ZatwierzCykle());
        zatwierdzDijkstra.addActionListener(new ZatwierzDijkstra());





        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);





    }
    class ZatwierdzWierzcholki implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlerWezly.setWezlyFromView(Integer.parseInt(wierzcholki.getText()));
            System.out.println(Integer.parseInt(wierzcholki.getText()));
            north2.setVisible(true);

        }
    }
    class Zwykly implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlerWezly.setMode(0);
            new ZatwierdzWierzcholki().actionPerformed(e);

        }
    }
    class GG implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlerWezly.setMode(1);
            new ZatwierdzWierzcholki().actionPerformed(e);

        }
    }
    class RNG implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlerWezly.setMode(2);
            new ZatwierdzWierzcholki().actionPerformed(e);

        }
    }

    class ZatwierzDijkstra implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println(start.getText());
            System.out.println(koniec.getText());
            ControlerStartKoniec.setStartKoniecFromView(start.getText(),koniec.getText());

        }
    }
    static class ZatwierzCykle implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setCykle(Cyklomierz.LiczCykle(getData()));

        }
    }



    public static  void setData(GraphData data) {
        centre.setData(data);


        frame.repaint();
    }
    public static GraphData getData(){
        return centre.getData();
    }

    public static void setCykle(JScrollPane sp){
        east.removeAll();
        east.add(sp);
        east.revalidate();
        east.repaint();
        System.out.println("dupalollolol");


    }

}
