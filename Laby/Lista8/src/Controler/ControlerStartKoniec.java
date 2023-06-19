package Controler;

import Data.GraphData;
import Observable.*;
import View.View1;

public class ControlerStartKoniec {
    private static ObservableStart obsstart;
    private static ObservableKoniec obskoniec;
    public  static void setObservables(ObservableStart start, ObservableKoniec koniec){
        obsstart=start;
        obskoniec= koniec;
    }
    private static String start;
    private static String koniec;

    public static void putDataToModel(){

        obsstart.setMeasurements(start);
        obskoniec.setMeasurements(koniec,View1.getData());
    }
    public static void setStartKoniecFromView(String start1, String koniec1){
        koniec = koniec1;
        start = start1;
        putDataToModel();
    }

    public static void dataToView(GraphData data)  {
        View1.setData(data);

    }





}
