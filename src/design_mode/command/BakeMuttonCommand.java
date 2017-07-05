package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public class BakeMuttonCommand extends Command {

    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    void execute() {
        receiver.bakeMutton();
    }

    @Override
    public String toString() {
        return "要一串羊肉";
    }

}
