package Algs;

import Data.GraphData;
import Data.*;
import Data.Vertex;
import Observable.ObservableKoniec;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Cyklomierz {


    public static  ArrayList LiczCykle(GraphData data){
        System.out.println("chuj");
        ArrayList returnlist = new ArrayList();
        HashMap<LinkedHashSet<Vertex>,Integer> cycles = new HashMap<>();


        for (Vertex vertex: data.getVertecies()) {
            List<Vertex> currentCycle = new ArrayList<>();
            HashSet<Vertex> visited = new HashSet<>();

            dfs(data,vertex,vertex,visited,currentCycle,cycles);

        }
        System.out.println("dupa: "+cycles.size());

        returnlist.add(pogrupuj(cycles,data));
        returnlist.add(cycles.size());

        return returnlist;






    }
    private static void dfs(GraphData data,Vertex startvertex, Vertex currentvertex, HashSet<Vertex> visited,List<Vertex> currentCycle,HashMap<LinkedHashSet<Vertex>,Integer> cycles){
        visited.add(currentvertex);
        currentCycle.add(currentvertex);




            for (Node nodesasiad: data.getMatrix().get(currentvertex)){
                Vertex sasiad = nodesasiad.getDestination();
                if(sasiad==startvertex && currentCycle.size()>2){

                    cycles.put(new LinkedHashSet<>(new ArrayList<>(currentCycle)),0);

                } else if (!visited.contains(sasiad)) {
                    dfs(data,startvertex,sasiad,visited,currentCycle,cycles);

                    
                }
            }
        visited.remove(currentvertex);
        currentCycle.remove(currentCycle.size()-1);







        }
    private static JScrollPane pogrupuj(HashMap<LinkedHashSet<Vertex>,Integer> cycles,GraphData data)    {
        for (LinkedHashSet<Vertex> cykl: cycles.keySet()){
            int waga = 0;
            ArrayList<Vertex> cykllist = new ArrayList<>(cykl);
            for (int i = 0; i <cykllist.size()-1 ; i++) {
                Vertex start = cykllist.get(i);
                Vertex koniec = cykllist.get(i+1);
                for(Edge edge: data.getEdges()){
                    if(edge.equals(new Edge(start,koniec,0))){
                        waga+=edge.getWaga();
                    }
                }


            }
            cycles.put(cykl,waga);
        }
        List<Map.Entry<LinkedHashSet<Vertex>,Integer>> entries = new ArrayList<>(cycles.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<LinkedHashSet<Vertex>, Integer>>() {
            @Override
            public int compare(Map.Entry<LinkedHashSet<Vertex>, Integer> o1, Map.Entry<LinkedHashSet<Vertex>, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        LinkedHashMap<LinkedHashSet<Vertex>,Integer> sortedMap= new LinkedHashMap<>();
        for(Map.Entry<LinkedHashSet<Vertex>,Integer> entry: entries){
            sortedMap.put(entry.getKey(),entry.getValue());

        }

        StringBuilder sb;
        String[] columns  ={"Cykl","Suma Wag"};
        String[][] dane = new String[entries.size()][columns.length];

        for (int i = 0; i <sortedMap.size() ; i++) {
            sb = new StringBuilder();
            Map.Entry<LinkedHashSet<Vertex>,Integer> entry = new ArrayList<>(sortedMap.entrySet()).get(i);
            ArrayList<Vertex> lista = new ArrayList<>(entry.getKey());
            sb.append(i+1).append(".").append(" ");
            for (Vertex vertex: lista){
                sb.append(vertex.getLabel()).append(" ");

            }
            dane[i][0]=sb.toString();
            dane[i][1]= String.valueOf(entry.getValue());

        }

        JTable tablica = new JTable(dane,columns);

        JScrollPane sp = new JScrollPane(tablica);
        return sp;





    }

}


