package figure;


import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public interface FigureMethods {

    //метод перемещения
    void move(Node changeVector);

    //метод вывода на экран
    void show(Graphics g);

    //метод масштабирования
    void scale(int multiplier);

    //площадь
    double area();

}
