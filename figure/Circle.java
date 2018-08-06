package figure;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Circle extends Figure implements FigureMethods {

    private int r;

    public Circle(Node [] points){
        super(points[0]);
        this.r = (int) points[0].distance(points[1]);
    }

    public Circle(Node center, int R){
        super(center);
        this.r = R;
    }

    public Circle(int x, int y, int R){
        super(x,y);
        this.r = R;
    }

    public void setR(int R){
        this.r = R;
    }
    public double getR(){
        return r;
    }

    @Override
    public void move(Node changeVector) {
        point.add(changeVector);
    }

    @Override
    public void show(Graphics g) {
        g.drawOval(point.getX(), point.getY(), r, r);
    }

    @Override
    public void scale(int multiplier) {
        this.r = this.r*multiplier;
    }

    @Override
    public double area() {
        if (r > 0) return Math.PI*r*r;
        else return 0.;
    }

    public boolean inCircle(Node point){
        if ((this.point).distance(point) <= r*r) return true;
        return false;
    }

    private double circleFormula (Node center, Node checkPoint){
        return Math.pow((center.getX() - checkPoint.getX()),2)+ Math.pow((center.getX() - checkPoint.getX()),2);
    }


    //если question внутри this, то 1
    //если this внутри question, то -1
    //иначе 0
    public int inCircle(Circle question){
        //сначала смотрим центр
        if (this.inCircle(question.point)){
            if ( circleFormula(question.point, this.point) <= this.r * this.r)
                return 1;
        } else if (question.inCircle(this.point)){
            if (circleFormula(question.point, this.point) <= question.r * question.r)
                return -1;
        }

        return 0;
    }
}
