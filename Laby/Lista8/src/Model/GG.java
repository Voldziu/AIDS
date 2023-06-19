package Model;

import Data.Edge;
import Data.GraphData;
import Data.Node;
import Data.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GG implements StrategyModel {
    @Override
    public GraphData DoModel(int wezly,int xdim, int ydim) {
        Random random = new Random();
        ArrayList<Vertex> vertices= new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        HashMap<Vertex,ArrayList<Node>> matrix = new HashMap<>();
        int litera =65;
        for (int i = 0; i <wezly ; i++) {
            int x = random.nextInt(xdim)+50;
            int y = random.nextInt(ydim)+50;
            vertices.add(new Vertex(String.valueOf((char) (litera+i)),x,y));
        }
        for (int i = 0; i <wezly ; i++) {
            Vertex a = vertices.get(i);
            for (int j = i+1; j <wezly ; j++) {
                Vertex b = vertices.get(j);
                double middlex = ((double) a.getX()+b.getX())/2;
                double middley = ((double) a.getY()+b.getY())/2;
                double radius2 = Math.pow((Math.pow(a.getX()-middlex,2)+Math.pow(a.getY()-middley,2)),2);

                int k=0;
                boolean notfound =true;
                while(k<wezly && notfound){
                    if(k!=i && k!=j){
                        Vertex c = vertices.get(k);
                        double distance2 = Math.pow((Math.pow(c.getX()-middlex,2)+Math.pow(c.getY()-middley,2)),2);
                        if(distance2<=radius2){
                            notfound=false;
                        }

                    }
                    k++;

                }
                if(notfound){
                    edges.add(new Edge(a,b,(int)Math.sqrt(radius2)/2));
                }



                }



            }
        for (int i = 0; i <wezly ; i++) {
            Vertex vertex = vertices.get(i);
            ArrayList<Node> lista = new ArrayList<>();
            lista.add(new Node(vertex,0));
            matrix.put(vertex,lista);

        }

        for (int i = 0; i <edges.size() ; i++) {
            Edge biezaca = edges.get(i);
            Vertex source = biezaca.getSource();
            Vertex target = biezaca.getTarget();
            matrix.get(source).add(new Node(target,biezaca.getWaga()));
            matrix.get(target).add(new Node(source,biezaca.getWaga()));



        }





        return new GraphData(vertices,edges,matrix);
    }
}