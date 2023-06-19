import Controler.ControlerStartKoniec;
import Controler.ControlerWezly;
import Observable.ObservableKoniec;
import Observable.ObservableStart;
import Observable.ObservableWezly;
import Observer.*;
import View.View1;

public class Main {
    public static void main(String[] args) {
        ObservableWezly observableWezly = new ObservableWezly();
        ControlerWezly.setObservable(observableWezly);
        ObservableStart observableStart = new ObservableStart();
        ObservableKoniec observableKoniec = new ObservableKoniec();
        ControlerStartKoniec.setObservables(observableStart,observableKoniec);
        Ozwykly zwykly = new Ozwykly(observableWezly);
        Ogg gg = new Ogg(observableWezly);
        Orng rng = new Orng(observableWezly);
        Ostartkoniec ostartkoniec = new Ostartkoniec(observableStart,observableKoniec);



        new View1().GUI_Create();
    }
}