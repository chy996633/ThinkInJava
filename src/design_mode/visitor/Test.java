package design_mode.visitor;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class Test {

    public static void main(String[] args) {
        ObjectStructure obj = new ObjectStructure();

        obj.attach(new Spring());
        obj.attach(new Summer());
        obj.attach(new Autumn());
        obj.attach(new Winter());

        obj.accept(new Tree());
        obj.accept(new Flower());
        //现在要添加一种鸟，不需要改动四季，只需要添加一种鸟的Visitor
        obj.accept(new Bird());

    }

}
