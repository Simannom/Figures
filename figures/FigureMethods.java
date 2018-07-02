package figure;


import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public interface FigureMethods {

    //метод перемещения
    void move(Node changeVector);

    //метод вывода на экран
    void show(Graphics2D g, int width, int height);

    //метод масштабирования
    void scale(double multiplier, Node centerPoint);

    //площадь
    Double area();

}
