package Observer;

import Controler.ControlerStartKoniec;
import Dijkstra.*;
import Observable.ObservableKoniec;
import Observable.ObservableStart;
import Observable.Subject;

public class Ostartkoniec extends Dijkstra implements Observer {
    private String start;
    private String koniec;
    private Subject sub;

    public Ostartkoniec(Subject sub) {
        this.sub = sub;
        this.sub.registerObserver(this);
        strategyDijkstra = new Dijkstra1();

    }

    @Override
    public void update(Subject sub, String napis) {
        if(sub instanceof ObservableStart){
            this.start=napis;
        } else if (sub instanceof ObservableKoniec) {
            this.koniec = napis;
            this.data=((ObservableKoniec) sub).getData();
            ControlerStartKoniec.dataToView(runCalculationsDijkstra(start,koniec,data));

        }


    }
}
