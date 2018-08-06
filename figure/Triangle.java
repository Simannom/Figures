package figure;


import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Triangle extends Figure implements FigureMethods{

    int side = 0;
    public Triangle (Node point, int side){
        super(point);
        this.side = side;
    }

    public Triangle (int x, int y, int side){
        super(x,y);
        this.side = side;
    }

    @Override
    public void move(Node changeVector) {
            point.add(changeVector);
    }

    //метод вывода на экран
    @Override
    public void show(Graphics g) {
        int [] x = new int [3];
        int [] y = new int [3];

        x[0] = point.getX();
        y[0] = point.getY();
        x[1] = x[0] - side/2;
        y[1] = (int) (y[0] + Math.sqrt(3) * side/ 2);
        x[2] = x[0] + side/2;
        y[2] = (int) (y[0] + Math.sqrt(3) * side/ 2);

        g.drawPolygon(x,y, 3);
    }

    //метод масштабирования
    @Override
    public void scale(int multiplier) {
        side *= multiplier;

        /*
        for (int i=0; i<3; ++i) {
            tmp.substract(points[i], centerPoint);
            points[i].add(centerPoint,tmp.multiply(multiplier));

        }
        */
    }

    //площадь
    @Override
    public double area() {
        //Heron formula
        Double area = Math.sqrt(3* Math.pow(side, 4)/ 16) ;
        return area;
    }
}