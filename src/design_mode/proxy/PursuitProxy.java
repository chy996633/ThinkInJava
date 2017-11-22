package design_mode.proxy;

public class PursuitProxy implements Givegift {

    private Pursuit pursuit;

    public PursuitProxy(SchoolGirl schoolGirl){
        this.pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void giveFlower() {
        pursuit.giveFlower();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }

    @Override
    public void giveLetter() {
        pursuit.giveLetter();
    }
}
