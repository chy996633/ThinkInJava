package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver){
        this.receiver = receiver;
    }

    abstract void execute();

}
