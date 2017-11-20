package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class LunchTimeState implements State{

    @Override
    public void handle(WorkEfficiency workEfficiency) {
        if (workEfficiency.getTime() < 13) {
            System.out.println(String.format(state, workEfficiency.getTime(), "打瞌睡"));
        }else {
            workEfficiency.setState(new AfternoonState());
            workEfficiency.handle();
        }
    }
}
