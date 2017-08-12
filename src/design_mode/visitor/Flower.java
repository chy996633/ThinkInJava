package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Flower implements SeasonVisitor {
    @Override
    public void visitSpring(Spring spring) {
        System.out.println("花儿在春天绽放");
    }

    @Override
    public void visitSummer(Summer summer) {
        System.out.println("花儿在夏天摇摆");
    }

    @Override
    public void vivisAutumn(Autumn autunm) {
        System.out.println("花儿在秋天凋零");
    }

    @Override
    public void visitWinter(Winter winter) {
        System.out.println("花儿在冬天枯萎");
    }
}
