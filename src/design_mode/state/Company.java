package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class Company {

    public static void main(String[] args) {

        WorkEfficiency workEfficiency = new WorkEfficiency();
        workEfficiency.handle();
        workEfficiency.setTime(10);
        workEfficiency.handle();
        workEfficiency.setTime(14);
        workEfficiency.handle();
        workEfficiency.setTime(16);
        workEfficiency.setTaskFinished(false);
        workEfficiency.handle();
        workEfficiency.setTime(21);
        workEfficiency.handle();
    }

}
