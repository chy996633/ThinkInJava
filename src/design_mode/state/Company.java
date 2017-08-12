package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class Company {

    public static void main(String[] args) {

        WorkEfficiency workEfficiency = new WorkEfficiency();
        workEfficiency.handle();
        State state = workEfficiency.getState();
        state.setTime(11);
        workEfficiency.handle();
        state = workEfficiency.getState();
        state.setTime(14);
        workEfficiency.handle();
        state = workEfficiency.getState();
        state.setTime(16);
        workEfficiency.setTaskFinished(false);
        workEfficiency.handle();
        state = workEfficiency.getState();
        state.setTime(21);
        workEfficiency.handle();
    }

}
