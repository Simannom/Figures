package figures;


import panel.ViewPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Circle extends Figure implements FigureMethods {

    private double r;

    public Circle(Node [] points){
        this.points = new Node[1];
        this.points[0] = points[0];
        this.r = points[0].distance(points[1]);
    }

    public Circle(Node center, double R){
        Node [] points = new Node[1];
        points[0] = center;
        this.r = R;
    }

    public void setR(double R){
        this.r = R;
    }
    public double getR(){
        return r;
    }

    @Override
    public void move(Node changeVector) {
        points[0].add(changeVector);
    }

    @Override
    public void show(Graphics2D g, int width, int height) {
        double x = this.points[0].getX();
        double y = this.points[0].getY();
        double r = ViewPanel.normalize(width,this.r);
        x = ViewPanel.normalize(width,x);
        y = ViewPanel.normalize(height,y);
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, r+r, r+r);
        g.draw(circle);
    }

    @Override
    public void scale(double multiplier, Node centerPoint) {
        this.r = this.r*multiplier;
    }

    @Override
    public Double area() {
        if (r > 0) return Math.PI*r*r;
        else return 0.;
    }

    public boolean inCircle(Node point){
        if (points[0].distance(point) <= r*r) return true;
        return false;
    }

    private double circleFormula (Node center, Node checkPoint){
        return Math.pow((center.getX() - checkPoint.getX()),2)+ Math.pow((center.getX() - checkPoint.getX()),2);
    }


    //if question is in this, return 1
    //if this inside question, return -1
    //else 0
    public int inCircle(Circle question){
        if (this.inCircle(question.points[0])){
            if ( circleFormula(question.points[0], this.points[0]) <= this.r * this.r)
                return 1;
        } else if (question.inCircle(this.points[0])){
            if (circleFormula(question.points[0], this.points[0]) <= question.r * question.r)
                return -1;
        }

        return 0;
    }
}
