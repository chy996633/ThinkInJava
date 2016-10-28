package v2;

/**
 * Created by Andrew on 2016/10/28.
 */
public class Programmer {

    private Integer name;
    public Programmer(Integer name){
        this.name = name;
    }

    void readyToWork(){
        System.out.println("程序员"+name+"正在埋头写代码");
    }

    void readyToRest(){
        System.out.println("程序员"+name+"走出去散散步");
    }



}
