package Observer;

import Controler.ControlerWezly;
import Data.GraphData;
import Model.*;
import Observable.*;

import java.util.ArrayList;

public class Ozwykly extends Model implements  Observer, Subject {
    ArrayList<Observer> ObserverList = new ArrayList<Observer>();
    private int wezly;
    private GraphData data;
    private  Subject sub;

    public Ozwykly(Subject sub){
        this.sub = sub;
        this.sub.registerObserver(this);
        strategyModel = new Zwykly();
    }


    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i<ObserverList.size(); i++) {
            ObserverList.get(i).update(this,"chuj");
        }
    }
    @Override
    public void update(Subject sub, String napis) {
        if (sub instanceof ObservableWezly){
            wezly= ((ObservableWezly) sub).getWezly();
            ControlerWezly.dataToView(strategyModel.DoModel(wezly,xdim,ydim));
        }


    }
}
