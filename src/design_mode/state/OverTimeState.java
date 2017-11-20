package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class OverTimeState implements State {

    @Override
    public void handle(WorkEfficiency workEfficiency) {
        if (workEfficiency.getTime() < 20) {
            System.out.println(String.format(state, workEfficiency.getTime(), "疲劳加班中"));
        }else {
            workEfficiency.setState(new MustRestState());
            workEfficiency.handle();
        }
    }
}
