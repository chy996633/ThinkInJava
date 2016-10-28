package v2;

import java.util.ArrayList;

/**
 * Created by Andrew on 2016/10/28.
 */
public class Office {
    Boss boss;
    StageGirl stageGirl;
    ArrayList<Programmer> programmers;

    public Office(){
        boss = new Boss();
        programmers = new ArrayList<>();
        for(int i=0;i<3;i++){
            programmers.add(new Programmer(i));
        }
        stageGirl = new StageGirl(boss,programmers);
    }

    public void bossEnter(){
        boss.enterOffice();
    }

    public void bossLeave(){
        boss.leaveOffice();
    }

    public static void main(String[] args) throws InterruptedException {

        Office office = new Office();
        office.stageGirl.observe();
        office.bossEnter();
        Thread.sleep(5);
        office.bossLeave();
        Thread.sleep(5);
        office.boss.status = 0;
    }



}
