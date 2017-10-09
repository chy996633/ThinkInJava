package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class AfternoonState implements State {

    public AfternoonState(Integer time) {
        this.time = time;
    }

    private Integer time;

    @Override
    public void handle(Context context) {
        if (time < 15) {
            System.out.println(String.format(state, time, "创意丰富"));
        } else {
            if (((WorkEfficiency)context).getTaskFinished()) {
                context.setState(new RestState(time));
            } else {
                context.setState(new OverTimeState(time));
            }
            context.handle();
        }
    }

    @Override
    public Integer getTime() {
        return time;
    }

    @Override
    public void setTime(Integer time) {
        this.time = time;
    }
}