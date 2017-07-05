package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public class Main {

    public static void main(String[] args) {
        //ready to do bussiness
        Waiter waiter = new Waiter();
        Barbecuer barbecuer = new Barbecuer();

        //customers' commands
        BakeChickenCommand chickenCommand = new BakeChickenCommand(barbecuer);
        BakeMuttonCommand muttonCommand = new BakeMuttonCommand(barbecuer);


        waiter.addCommand(chickenCommand);
        waiter.addCommand(muttonCommand);
        //cancel a command
        waiter.cancelCommand(chickenCommand);

        //start to bake
        waiter.notifyCommand();


    }

}
