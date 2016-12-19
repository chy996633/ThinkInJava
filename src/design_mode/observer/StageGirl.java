package design_mode.observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Andrew on 2016/10/31.
 */
public class StageGirl extends Observable implements Observer {

    private static final String WORK = "1";
    private static final String REST = "0";
    ArrayList<Programmer> programmers;


    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String){
            setChanged();
            if (arg.equals(WORK)) {
                System.out.println("老板进来了");
                notifyObservers(WORK);
            }

            if (arg.equals(REST)) {
                System.out.println("老板离开了");
                notifyObservers(REST);
            }

        }

    }

}
