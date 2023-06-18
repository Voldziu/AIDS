package Dijkstra;

import Data.GraphData;
import Data.Vertex;

public abstract class Dijkstra {
    protected GraphData data;
    protected StrategyDijkstra strategyDijkstra;
    public GraphData runCalculationsDijkstra(String start, String koniec,GraphData data){
        return strategyDijkstra.DoDijkstra(start,koniec,data);

    }

}
