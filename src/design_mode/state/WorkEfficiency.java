package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class WorkEfficiency implements Context{

    private State state;

    private Boolean taskFinished = true;

    private Integer time;

    public WorkEfficiency(){
        this.time = 8;
        this.state = new MorningState();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getTaskFinished() {
        return taskFinished;
    }

    public void setTaskFinished(Boolean taskFinished) {
        this.taskFinished = taskFinished;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void handle() {
        state.handle(this);
    }


}
