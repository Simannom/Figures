package figures;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public abstract class Figure implements FigureMethods{
    protected Node [] points;


    //íàäî âñÿêèõ ïðîâåðîê äîáàâèòü
    public Figure(){
        points = new Node[3];
        for (int i = 0; i < points.length; ++i){
            points[i] = new Node(0,0);
        }
    }

    public Figure(Node [] points){
        this.points = points;
    }

    public Figure( double [] x, double [] y) {
        int l = x.length > y.length ? y.length : x.length;
        this.points = new Node[l];
        for (int i = 0; i < l; ++i){
            points[i] = new Node(x[i], y[i]);
        }
    }


    @Override
    public void move(Node changeVector) {

    }

    @Override
    public void show(Graphics2D g, int width, int height) {

    }

    @Override
    public void scale(double multiplier, Node centerPoint) {

    }

    @Override
    public Double area() {
        return null;
    }
}
