package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class MorningState implements State {

    public MorningState(Integer time) {
        this.time = time;
    }

    private Integer time;

    @Override
    public void handle(Context context) {
        if (time < 10) {
            System.out.println(String.format(state, time, "棒棒哒"));
        }else{
            context.setState(new LunchTimeState(time));
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
