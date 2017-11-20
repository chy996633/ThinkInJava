package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class MorningState implements State {

    @Override
    public void handle(WorkEfficiency workEfficiency) {
        if (workEfficiency.getTime() < 10) {
            System.out.println(String.format(state, workEfficiency.getTime(), "棒棒哒"));
        }else{
            workEfficiency.setState(new LunchTimeState());
            workEfficiency.handle();
        }
    }
}
