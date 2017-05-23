package interfaces;

/**
 * Created by backstop-samuel on 5/23/17.
 */
public class InterfaceTestImpl implements InterfaceTest {

    public void publicAbstractMethod(){

    };

    @Override
    public InterfaceTest getCanUseInterfaceAsMember() {
        return canUseInterfaceAsMember;
    }
}
