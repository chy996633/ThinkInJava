package jvm;

/**
 * VM args: -Xss128k
 */
public class JavaVMStackSOE {

    public int length = 0;

    public static void main(String[] args) {
        JavaVMStackSOE j = new JavaVMStackSOE();
        try {
            j.stackLeak();

        }catch (Throwable e) {
            System.out.println("stack max length: " + j.length);
            throw e;
        }
    }

    private void stackLeak() {
        length++;
        stackLeak();
    }

}
