package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public class BakeChickenCommand extends Command {
    public BakeChickenCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    void execute() {
        ((Barbecuer)receiver).bakeChickenWing();
    }

    @Override
    public String toString() {
        return "要一个鸡翅膀";
    }
}
