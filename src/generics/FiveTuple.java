package generics;

public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {

    public final E fifth;

    public FiveTuple(A a, B b, C c, D fourth,E fifth) {
        super(a, b, c, fourth);
        this.fifth = fifth;
    }

    @Override
    public String toString() {
        return "( "+first+" , "+second+" , "+third+" , "+fourth+" , "+fifth+" )";
    }
}
