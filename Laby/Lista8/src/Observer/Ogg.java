package Observer;

import Controler.ControlerWezly;
import Data.GraphData;
import Model.*;
import Observable.*;

import java.util.ArrayList;

public class Ogg extends Model implements  Observer {

    private int wezly;
    private GraphData data;
    private  Subject sub;

    public Ogg(Subject sub){
        this.sub = sub;
        this.sub.registerObserver(this);
        strategyModel = new GG();
    }



    @Override
    public void update(Subject sub, String napis) {
        if (sub instanceof ObservableWezly){
            wezly= ((ObservableWezly) sub).getWezly();
            ControlerWezly.dataToView(strategyModel.DoModel(wezly,xdim,ydim));
        }


    }
}