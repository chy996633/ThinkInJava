package design_mode.proxy;

public class Pursuit implements Givegift {

    private SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveFlower() {
        System.out.println(schoolGirl.getName()+",隔壁小王给你送花了");
    }

    @Override
    public void giveChocolate() {
        System.out.println(schoolGirl.getName()+",隔壁小王给你送巧克力了");
    }

    @Override
    public void giveLetter() {
        System.out.println(schoolGirl.getName()+",隔壁小王给你写信了");
    }
}
