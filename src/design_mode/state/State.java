package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public interface State {

    String state = "现在是%d点,工作状态是:%s";

    void handle(WorkEfficiency workEfficiency);

}
