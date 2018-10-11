package design_mode.creational.abstract_factory;

/**
 * Created by Andrew on 2016/11/3.
 */
public class TildePointCornerFactory implements PointCornerFactory {

    @Override
    public Corner getCorner() {
        return new Corner() {
            @Override
            public void leftUp() {
                System.out.print("*");
            }

            @Override
            public void rightUp() {
                System.out.print("*");
            }

            @Override
            public void leftDown() {
                System.out.print("*");
            }

            @Override
            public void rightDown() {
                System.out.print("*");
            }
        };
    }

    @Override
    public Point getPoint() {
        return new Point() {
            @Override
            public void line(int width) {
                for (int i=0;i<width;i++){
                    System.out.print("~");
                }
            }
        };
    }

}
