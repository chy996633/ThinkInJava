package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class OverTimeState implements State {

    public OverTimeState(Integer time) {
        this.time = time;
    }

    private Integer time;

    @Override
    public void handle(Context context) {
        System.out.println(String.format(state, time, "疲劳加班中"));
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
