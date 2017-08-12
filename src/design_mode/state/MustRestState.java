package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class MustRestState implements State {
    private Integer time;

    public MustRestState(Integer time) {
        this.time = time;
    }

    @Override
    public void handle(Context context) {
        System.out.println(String.format(state, time, "下班途中,公司规定20点之前必须下班"));
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
