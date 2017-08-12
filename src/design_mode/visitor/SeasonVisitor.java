package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 * 访问者模式
 */
public interface SeasonVisitor {

    void visitSpring(Spring spring);

    void visitSummer(Summer summer);

    void vivisAutumn(Autumn autunm);

    void visitWinter(Winter winter);

}
