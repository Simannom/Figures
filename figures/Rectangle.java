package figure;

import panel.MainFrame;
import panel.ViewPanel;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Rectangle extends Figure implements FigureMethods{



    public Rectangle(Node [] points){
        this.points = new Node [4];
        this.points[0] = points[0];
        this.points[2] = points[1];
        this.points[1] = new Node (points[0].getX(), points[1].getY());
        this.points[3] = new Node (points[1].getX(), points[0].getY());
    }

    @Override
    public void move(Node changeVector) {
        for (int i = 0; i < 4; ++i ){
            points[0].add(changeVector);
        }
    }

    @Override
    public void show(Graphics2D g, int width, int height) {
        int [] x = new int [4];
        int [] y = new int [4];
        for (int i =0; i<4;++i) {
            x[i] = ViewPanel.normalize(width, this.points[i].getX());
            y[i] = ViewPanel.normalize(height, this.points[i].getY());
        }
        g.drawPolygon(x,y, 4);
    }

    @Override
    public void scale(double multiplier, Node centerPoint) {
        Node tmp = new Node(0,0);
        for (int i=0; i<4; ++i) {
            tmp.substract(points[i], centerPoint);
            points[i].add(centerPoint,tmp.multiply(multiplier));

        }
    }

    @Override
    public Double area() {
        double a = points[0].distance(points[1]);
        double b = points[1].distance(points[3]);
        return a*b;
    }
}
