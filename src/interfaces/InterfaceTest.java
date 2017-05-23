package interfaces;

import com.sun.deploy.util.StringUtils;

/**
 * Created by backstop-samuel on 5/23/17.
 */
public interface InterfaceTest {

    final String canUseStringAsMember = null;

    final int canUseIntAsMember = 1;

    public abstract void publicAbstractMethod();

    final InterfaceTest canUseInterfaceAsMember = new InterfaceTest() {
        @Override
        public void publicAbstractMethod() {

        }

        @Override
        public InterfaceTest getCanUseInterfaceAsMember() {
            return null;
        }
    };


    InterfaceTest getCanUseInterfaceAsMember();



}
