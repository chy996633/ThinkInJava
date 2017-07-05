package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

    abstract void execute();

}
