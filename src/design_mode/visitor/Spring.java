package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Spring implements Season{
    @Override
    public void accept(SeasonVisitor seasonVisitor) {
        seasonVisitor.visitSpring(this);
    }
}
