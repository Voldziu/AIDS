package Observer;

import Controler.ControlerWezly;
import Data.GraphData;
import Model.*;
import Observable.*;

import java.util.ArrayList;

public class Orng extends Model implements  Observer {

    private int wezly;

    private  Subject sub;

    public Orng(Subject sub){
        this.sub = sub;
        this.sub.registerObserver(this);
        strategyModel = new RNG();
    }



    @Override
    public void update(Subject sub, String napis) {
        if (sub instanceof ObservableWezly){
            wezly= ((ObservableWezly) sub).getWezly();
            if(ControlerWezly.getMode()==2){
                ControlerWezly.dataToView(strategyModel.DoModel(wezly,xdim,ydim));
            }

        }


    }
}
