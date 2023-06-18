package Dijkstra;

import Data.GraphData;
import Data.Vertex;

public abstract class Dijkstra {
    public StrategyDijkstra strategyDijkstra;
    public GraphData runCalculationsDijkstra(Vertex start, Vertex koniec){
        return strategyDijkstra.DoDijkstra(start,koniec);

    }

}
