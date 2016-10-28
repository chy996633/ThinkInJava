package v2;

import java.util.ArrayList;

/**
 * Created by Andrew on 2016/10/28.
 */
public class StageGirl {

    ArrayList<Programmer> programmers;

    Boss boss;

    public StageGirl(Boss boss, ArrayList programmers) {
        this.boss = boss;
        this.programmers = programmers;
    }

    public void observe() {
        Runnable a = () -> {
            while (true) {
                if (boss.status == 0){
                    continue ;
                }

                if (boss.status == 1) {
                    System.out.println("前台：老板来了");
                    for (int i = 0; i < programmers.size(); i++) {
                        {
                            Programmer p = programmers.get(i);
                            p.readyToWork();
                        }
                    }
                } else if (boss.status == -1) {
                    System.out.println("前台：老板离开了");
                    for (int i = 0; i < programmers.size(); i++) {
                        {
                            Programmer p = programmers.get(i);
                            p.readyToRest();
                        }
                    }
                }
            }
        };
        Thread d = new Thread(a);
        d.start();
    }

}
