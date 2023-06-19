package Controler;

import Data.GraphData;
import Observable.ObservableWezly;
import View.View1;

public class ControlerWezly {
    private static int mode;
    private static ObservableWezly obs;
    public static void setObservable(ObservableWezly o) {
        obs = o;
    }
    private static int wezly;

    public static void putDataToModel() {

        obs.setMeasurements(wezly);
    }

    public static void setWezlyFromView(int wezly2) {

        if (wezly2 > 0 && wezly2<11) {

            wezly = wezly2;

            putDataToModel();
        }
        else{
            System.out.println("mordo zle ");
        }

    }

    public static void dataToView(GraphData data){
        View1.setData(data);
    }

    public static int getWezly() {
        return wezly;
    }

    public static void setWezly(int wezly) {
        ControlerWezly.wezly = wezly;
    }

    public static int getMode() {
        return mode;
    }

    public static void setMode(int mode) {
        ControlerWezly.mode = mode;
    }
}
