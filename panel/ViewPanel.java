package panel;

import figure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ViewPanel extends JPanel {



    private ArrayList<figure.Node> points;
    private ArrayList<Figure> figures;
    private int it = 0;
    private static double minX = 0, maxX = 1, minY = 0, maxY = 1;
    private static int MARGIN_X = 8, MARGIN_Y = 8;
    private static int figureType = 0;


    public void setRandom(int N) {
        Random random = new Random();
        points = new ArrayList<>(N);
        int x,y;
        for (int i = 0; i < N; i++) {
            points.add(new Node(random.nextFloat(), random.nextFloat()));
        }
        repaint();
    }

    public void changeFigureType(int f){
        if (figureType != 0){
            if (figureType == 2){
                for (int i = it; i < points.size(); i+=2){
                    Node [] tmp = new Node [2];
                    for (int j =0; j < tmp.length; ++j){
                        tmp[i] = points.get(i+j);
                    }
                    Figure toAdd = new Circle(tmp);
                    figures.add(toAdd);
                    it = i;
                }

            }
            if (figureType == 3){

                for (int i = it; i < points.size(); i+=3) {
                    Node [] tmp = new Node [3];
                    for (int j =0; j < tmp.length; ++j){
                        tmp[i] = points.get(i+j);
                    }
                    Figure toAdd = new Triangle(tmp);
                    figures.add(toAdd);
                    it = i;
                }
            }
            if (figureType == 4){
                for (int i = it; i < points.size(); i+=2) {
                    Node [] tmp = new Node [2];
                    for (int j =0; j < tmp.length; ++j){
                        tmp[i] = points.get(i+j);
                    }
                    Figure toAdd = new figure.Rectangle(tmp);
                    figures.add(toAdd);
                    it = i;
                }
            }

        }
        figureType = f;
        repaint();

    }


    public void pointsFromUser(Node p){
        points.add(p);
        step++;
        repaint();
    }


    private int step;
    public void next() {
        step++;
        repaint();
    }


    public static int normalize(int rect, double change){
        return (int) Math.round((rect - 2 * MARGIN_X) * (change - minX) / (maxX - minX));
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        Rectangle rect = getBounds();
        g.fillRect(0, 0, rect.width, rect.height);

        if (points != null) {
            for (int i = 0; i < points.size(); i++) {
                int x = normalize (rect.width, points.get(i).getX() );
                int y = normalize (rect.height, points.get(i).getY() );

                g.setColor(Color.BLACK);
                g.fillOval(x - 3, y - 3, 7, 7);
            }
        }

        if (figures != null) {
            for (int i = 0; i < figures.size(); i++) {
                if (i<step) {
                    figures.get(i).show(g2, rect.width, rect.height);
                }
            }
        }

    }
}
