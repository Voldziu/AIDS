package Controler;

import Data.GraphData;
import Observable.ObservableWezly;
import View.View1;

public class ControlerWezly {
    private static ObservableWezly obs;
    public static void setObserbale(ObservableWezly o) {
        obs = o;
    }
    private static int wezly;

    public static void putDataToModel() {

        obs.setMeasurements(wezly);
    }

    public static void setWezlyFromView(int wezly2) {

        if (wezly > 0 && wezly<11) {

            wezly = wezly2;

            putDataToModel();
        }
        else
            System.out.println("mordo zle ");
    }

    public static void dataToView(GraphData data){
        View1.setData(data);
    }



}
