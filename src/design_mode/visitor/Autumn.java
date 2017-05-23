package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Autumn implements Season {
    @Override
    public void accept(SeasonVisitor seasonVisitor) {
        seasonVisitor.vivisAutumn(this);
    }
}
