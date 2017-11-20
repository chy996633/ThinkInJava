package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class MustRestState implements State {
    @Override
    public void handle(WorkEfficiency workEfficiency) {
        System.out.println(String.format(state, workEfficiency.getTime(), "下班途中,公司规定20点之前必须下班"));
    }
}
