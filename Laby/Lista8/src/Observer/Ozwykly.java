package Observer;

import Controler.ControlerWezly;
import Data.GraphData;
import Model.*;
import Observable.*;

import java.util.ArrayList;

public class Ozwykly extends Model implements  Observer {

    private int wezly;
    private GraphData data;
    private  Subject sub;

    public Ozwykly(Subject sub){
        this.sub = sub;
        this.sub.registerObserver(this);
        strategyModel = new Zwykly();
    }



    @Override
    public void update(Subject sub, String napis) {
        if (sub instanceof ObservableWezly){
            wezly= ((ObservableWezly) sub).getWezly();
            ControlerWezly.dataToView(strategyModel.DoModel(wezly,xdim,ydim));
        }


    }
}
