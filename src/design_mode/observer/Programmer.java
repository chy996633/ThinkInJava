package design_mode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Andrew on 2016/10/28.
 */
public class Programmer implements Observer {

    private String name;
    public Programmer(String name){
        this.name = name;
    }

    void readyToWork(){
        System.out.println("程序员"+name+"正在埋头写代码");
    }

    void readyToRest(){
        System.out.println("程序员"+name+"走出去散散步");
    }


    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String){
            if (arg.equals("1")){
                readyToWork();
            }
            if (arg.equals("0")){
                readyToRest();
            }
        }
    }
}
