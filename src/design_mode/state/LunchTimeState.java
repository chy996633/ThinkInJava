package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class LunchTimeState implements State{
    public LunchTimeState(Integer time) {
        this.time = time;
    }

    private Integer time;

    @Override
    public void handle(Context context) {
        if (time < 13) {
            System.out.println(String.format(state, time, "打瞌睡"));
        }else {
            context.setState(new AfternoonState(time));
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
