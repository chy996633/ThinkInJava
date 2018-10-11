package design_mode.creational.abstract_factory;

/**
 * Created by Andrew on 2016/11/3.
 */
public class Rectangle {

    int width;
    int height;

    Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }

    public void paint(PointCornerFactory pointCornerFactory){

        Corner corner = pointCornerFactory.getCorner();
        Point point = pointCornerFactory.getPoint();
        corner.leftUp();
        point.line(width - 2);
        corner.rightUp();
        System.out.println();
        for(int i=0;i<height - 2;i++){
            point.line(width);
            System.out.println();
        }
        corner.leftDown();
        point.line(width - 2);
        corner.rightDown();
        System.out.println();

    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(20,10);
        rect.paint(new LinePointCornerFactory());
//        rect.paint(new TildePointCornerFactory());

    }


}
