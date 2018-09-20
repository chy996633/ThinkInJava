package design_mode.visitor;

public class Bird implements SeasonVisitor {

    @Override
    public void visitSpring(Spring spring) {
        System.out.println("鸟儿在春天歌唱");
    }

    @Override
    public void visitSummer(Summer summer) {
        System.out.println("鸟儿在夏天飞翔");
    }

    @Override
    public void vivisAutumn(Autumn autunm) {
        System.out.println("鸟儿在秋天回家");
    }

    @Override
    public void visitWinter(Winter winter) {
        System.out.println("鸟儿在冬天躲起来");
    }
}
