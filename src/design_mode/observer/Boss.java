package design_mode.observer;

import java.util.Observable;

/**
 * Created by Andrew on 2016/10/31.
 */
public class Boss extends Observable {


    public void enterOffice(){
        setChanged();
        notifyObservers("1");
    }

    public void leaveOffice(){
        setChanged();
        notifyObservers("0");
    }


}
