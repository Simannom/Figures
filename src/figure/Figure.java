package figure;

import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public abstract class Figure implements FigureMethods{
    protected Node point;


    //надо всяких проверок добавить
    public Figure(){
        point = new Node(0,0);
    }

    public Figure(Node point){
        this.point = point;
    }

    public Figure(int x, int y) {
        this.point =  new Node(x, y);
    }


    @Override
    public void move(Node changeVector) {

    }

    @Override
    public void show(Graphics g) {

    }

    @Override
    public void scale(int multiplier) {

    }

    @Override
    public double area() {
        return 0;
    }
}
