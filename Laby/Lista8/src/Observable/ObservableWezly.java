package Observable;

import java.util.ArrayList;
import Observer.*;

public class ObservableWezly implements Subject{
    ArrayList<Observer> ObserverList = new ArrayList<Observer>();
    private int Wezly;

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
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(int wezly) {
        this.Wezly = wezly;
        measurementsChanged();
    }

    public int getWezly() {
        return Wezly;
    }

    public void setWezly(int wezly) {
        Wezly = wezly;
    }
}
