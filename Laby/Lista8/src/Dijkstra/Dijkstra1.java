package Dijkstra;

import Data.*;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Dijkstra1 implements  StrategyDijkstra{

    @Override
    public GraphData DoDijkstra(String start, String koniec, GraphData data) {



        Vertex Vstart = data.getVertecies().get((int)(start.charAt(0))-65);
        Vertex Vkoniec = data.getVertecies().get((int)(koniec.charAt(0))-65);
        HashSet<Vertex> resolved= new HashSet<>();
        HashMap<Vertex,Integer> distances = new HashMap<>();
        HashMap<Vertex,Vertex> previous= new HashMap<>();

        for (Vertex vertex: data.getVertecies()){
            distances.put(vertex,Integer.MAX_VALUE);
            previous.put(vertex,null);
        }
        BinaryHeap<HeapNode> binaryHeap = new BinaryHeap<>(new Comparator<HeapNode>() {
            @Override
            public int compare(HeapNode o1, HeapNode o2) {
                return o1.compareTo(o2);
            }
        });
        binaryHeap.enqueue(new HeapNode(Vstart,0));
        distances.put(Vstart,0);
        resolved.add(Vstart);

        while(!binaryHeap.isEmpty()){
            HeapNode Node = binaryHeap.dequeue();
            Vertex vertex = Node.getDestination();
            int waga = Node.getWaga();
            resolved.add(vertex);

            for(Data.Node node: data.getMatrix().get(vertex)){
                Vertex destination = node.getDestination();
                int weight = node.getWaga();
                int newWeight = waga+weight;
                if(!resolved.contains(destination) && newWeight<distances.get(destination)){
                    distances.put(destination,newWeight);
                    previous.put(destination,vertex);
                    binaryHeap.enqueue(new HeapNode(destination,newWeight));
                }

            }

        }


        ArrayList<Vertex> path = new ArrayList<>();
        Vertex current = Vkoniec;
        while(current!=null){
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);

        for(Vertex vertex: path){
            System.out.print(vertex.getLabel()+" ");
        }
        System.out.println();

        for(Edge edge : data.getEdges()){
            edge.setColor(false);
        }

        for (int i = 0; i <path.size()-1 ; i++) {
            Vertex source = path.get(i);
            Vertex dest = path.get(i+1);
            Edge newEdge = new Edge(source,dest,0);
            Edge reversedEdge = new Edge(dest,source,0);
            for( Edge edge: data.getEdges()){
                if(edge.equals(newEdge) || edge.equals(reversedEdge)){
                    edge.setColor(true);
                    break;
                }
            }

        }







        return data;
    }
}
