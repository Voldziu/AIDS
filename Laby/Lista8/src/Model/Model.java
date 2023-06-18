package Model;

import Data.GraphData;

public abstract class Model {
    public StrategyModel strategyModel;
    protected final int xdim =1000;
    protected final int ydim =1000;

    public GraphData runCalculations(int wezly){
        return  strategyModel.DoModel(wezly,xdim,ydim);
    }
}
