package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public class Barbecuer implements Receiver{

    public void bakeMutton(){
        System.out.println("正在烤一串羊肉串");
    }

    public void bakeChickenWing(){
        System.out.println("正在烤一串烤鸡翅");
    }

}
