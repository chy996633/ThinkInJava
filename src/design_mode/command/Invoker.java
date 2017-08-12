package design_mode.command;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public interface Invoker {

    void addCommand(Command command);

    void cancelCommand(Command command);

    void notifyCommand();

}
