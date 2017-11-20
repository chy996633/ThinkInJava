package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class AfternoonState implements State {

    @Override
    public void handle(WorkEfficiency workEfficiency) {
        if (workEfficiency.getTime() < 15) {
            System.out.println(String.format(state, workEfficiency.getTime(), "创意丰富"));
        } else {
            if (workEfficiency.getTaskFinished()) {
                workEfficiency.setState(new RestState());
            } else {
                workEfficiency.setState(new OverTimeState());
            }
            workEfficiency.handle();
        }
    }
}
