package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Tree implements SeasonVisitor {
    @Override
    public void visitSpring(Spring spring) {
        System.out.println("春天到了，树木开始长出嫩芽和新枝");
    }

    @Override
    public void visitSummer(Summer summer) {
        System.out.println("夏天来了，树叶开始变得繁茂");
    }

    @Override
    public void vivisAutumn(Autumn autunm) {
        System.out.println("秋天到了，树叶开始凋零");
    }

    @Override
    public void visitWinter(Winter winter) {
        System.out.println("冬天到了，树木开始冬眠");
    }
}
