package Model;

import Data.Edge;
import Data.GraphData;
import Data.Node;
import Data.Vertex;
import View.View1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Zwykly implements StrategyModel {
    @Override
    public GraphData DoModel(int wezly,int xdim, int ydim) {
        Random random = new Random();
        int ilesasiadow = Math.max(wezly,3);
        ArrayList<Vertex> vertices= new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        HashMap<Vertex,ArrayList<Node>> matrix = new HashMap<>();
        int litera =65;
        int radius = Math.min(xdim,ydim)/2;

        for (int i = 0; i <wezly ; i++) {
            int x = (int) (radius * Math.cos(2* Math.PI *i/wezly))+xdim/2;
            int y = (int) (radius * Math.sin(2 * Math.PI *i/wezly))+ydim/2;
            vertices.add(new Vertex(String.valueOf((char) litera+i),x,y));

        }
        for (int i = 0; i <wezly ; i++) {

            ArrayList<Vertex> sasiedzi=new ArrayList<>();
            Vertex source = vertices.get(i);
            for (int j = 0; j <ilesasiadow ; j++) {
                int k = random.nextInt(wezly);
                Vertex sasiad = vertices.get(k);
                if(!sasiedzi.contains(sasiad) && k!=i && !edges.contains(new Edge(source,sasiad,0)) ){
                    sasiedzi.add(sasiad);
                    edges.add(new Edge(source,sasiad, random.nextInt(25)));

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
