package Observable;

import Data.GraphData;
import Observer.Observer;

import java.util.ArrayList;

public class ObservableKoniec implements Subject{
    ArrayList<Observer> ObserverList = new ArrayList<Observer>();
    private String koniec;
    private GraphData data;

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
            ObserverList.get(i).update(this,"koniec");
        }
    }
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(String  koniec,GraphData data) {
        this.koniec = koniec;
        this.data=data;
        measurementsChanged();
    }

    public GraphData getData() {
        return data;
    }

    public void setData(GraphData data) {
        this.data = data;
    }
}
