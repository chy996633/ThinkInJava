package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Summer implements Season {
    @Override
    public void accept(SeasonVisitor seasonVisitor) {
        seasonVisitor.visitSummer(this);
    }
}
