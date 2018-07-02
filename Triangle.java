package figure;

import panel.ViewPanel;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Triangle extends Figure implements FigureMethods{

    public Triangle (Node[] points){
        for (int i = 0; i < 3; ++i) {
            this.points[i] = points[i];
        }
    }

    @Override
    public void move(Node changeVector) {
        for (int i = 0; i<3; ++i){
            points[i].add(changeVector);
        }
    }

    //метод вывода на экран
    @Override
    public void show(Graphics2D g, int width, int height) {
        int [] x = new int [3];
        int [] y = new int [3];
        for (int i =0; i<3;++i) {
            x[i] = ViewPanel.normalize(width, this.points[i].getX());
            y[i] = ViewPanel.normalize(height, this.points[i].getY());
        }
        g.drawPolygon(x,y, 3);
    }

    //метод масштабирования
    @Override
    public void scale(double multiplier, Node centerPoint) {
        Node tmp = new Node(0,0);
        for (int i=0; i<3; ++i) {
            tmp.substract(points[i], centerPoint);
            points[i].add(centerPoint,tmp.multiply(multiplier));

        }
    }

    //площадь
    @Override
    public Double area() {
        double a = points[0].distance(points[1]);
        double b = points[1].distance(points[2]);
        double c = points[2].distance(points[0]);
        //Heron formula
        double p = (a+b+c)/2;
        Double area = Math.sqrt(p*(p-a)*(p-b)*(p-c)) ;
        return area;
    }
}