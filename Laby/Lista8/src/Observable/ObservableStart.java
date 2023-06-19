package Observable;

import Observer.Observer;

import java.util.ArrayList;

public class ObservableStart implements Subject{
    ArrayList<Observer> ObserverList = new ArrayList<Observer>();
    private String start;

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
            ObserverList.get(i).update(this,start);
        }
    }
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(String  start) {
        this.start = start;
        measurementsChanged();
    }

}
