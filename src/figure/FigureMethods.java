package figure;


import java.awt.*;

/**
 * Created by Simannom on 18.06.2018.
 */
public interface FigureMethods {

    //����� �����������
    void move(Node changeVector);

    //����� ������ �� �����
    void show(Graphics g);

    //����� ���������������
    void scale(int multiplier);

    //�������
    double area();

}
