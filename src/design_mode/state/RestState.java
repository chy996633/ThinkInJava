package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class RestState implements State {

    public RestState(Integer time) {
        this.time = time;
    }

    private Integer time;

    @Override
    public void handle(Context context) {
        System.out.println(String.format(state, time, "准备休息了"));
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
