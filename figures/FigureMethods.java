package figures;


import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public interface FigureMethods {

    void move(Node changeVector);

    void show(Graphics2D g, int width, int height);

    void scale(double multiplier, Node centerPoint);

    Double area();

}
