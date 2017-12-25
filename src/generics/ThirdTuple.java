package generics;

public class ThirdTuple<A, B, C> extends TwoTuple<A, B> {

    public final C third;

    public ThirdTuple(A first, B second, C third){
        super(first, second);
        this.third = third;
    }

}
