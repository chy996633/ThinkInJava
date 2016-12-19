package design_mode.observer;

/**
 * Created by Andrew on 2016/10/28.
 */
public class Office {
    Boss boss;
    StageGirl stageGirl;

    public Office(){
        boss = new Boss();
        stageGirl = new StageGirl();
        boss.addObserver(stageGirl);
        Programmer p1 = new Programmer("令狐冲");
        Programmer p2 = new Programmer("任我行");
        Programmer p3 = new Programmer("乔布斯");
        stageGirl.addObserver(p1);
        stageGirl.addObserver(p2);
        stageGirl.addObserver(p3);
        stageGirl.hasChanged();

    }

    public void bossEnter(){
        boss.enterOffice();
    }

    public void bossLeave(){
        boss.leaveOffice();
    }

    public static void main(String[] args) throws InterruptedException {

        Office office = new Office();
        office.bossEnter();
        office.bossLeave();
    }



}
