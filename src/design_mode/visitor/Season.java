package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public interface Season {
    void accept(SeasonVisitor seasonVisitor);
}
