package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class RestState implements State {

    @Override
    public void handle(WorkEfficiency workEfficiency) {
        System.out.println(String.format(state, workEfficiency.getTime(), "准备休息了"));
    }

}
