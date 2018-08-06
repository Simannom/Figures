package figure;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public class Rectangle extends Figure implements FigureMethods{

    int a = 0;
    int b = 0;

    public Rectangle(Node point, int a, int b){
        super(point);
        this.a = a;
        this.b = b;
    }

    public Rectangle(int x, int y, int a, int b){
        super(x,y);
        this.a = a;
        this.b = b;
    }

    @Override
    public void move(Node changeVector) {
        point.add(changeVector);
    }

    @Override
    public void show(Graphics g) {
        g.drawRect(point.getX(), point.getY(), a, b);
    }

    @Override
    public void scale(int multiplier) {
        this.a = a*multiplier;
        this.b = b*multiplier;
    }

    @Override
    public double area() {
        return a*b;
    }
}
