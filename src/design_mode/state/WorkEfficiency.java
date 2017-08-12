package design_mode.state;

/**
 * Created by backstop-samuel on 7/5/17.
 */
public class WorkEfficiency implements Context{

    private State state = new MorningState(8);

    private Boolean taskFinished = true;

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
