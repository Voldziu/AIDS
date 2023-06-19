package Model;

import Data.GraphData;

public abstract class Model {
    public StrategyModel strategyModel;
    protected final int xdim =500;
    protected final int ydim =500;

    public GraphData runCalculations(int wezly){
        return  strategyModel.DoModel(wezly,xdim,ydim);
    }
}
