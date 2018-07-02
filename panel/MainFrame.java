package panel;

import figure.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


// AWT Abstract Window Toolkit
// Swing
// http://zetcode.com/tutorials/javaswingtutorial/

public class MainFrame extends JFrame {

    private ViewPanel view;
    private Timer timer;

    private void onStartClickRandom() {
        view.setRandom(10);
        timer.start();
    }

    private void onStartClick(double x, double y) {
        view.pointsFromUser(new Node(x,y));
        timer.start();
    }

    public MainFrame() {
        setTitle("Рисуем фигуры");
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton start = new JButton();
        start.setText("Start with random points");

        //JButton start2 = new JButton();
        //start.setText("Start and choose point");

        JButton rect = new JButton();
        rect.setText("Rectangles");

        JButton triangle = new JButton();
        triangle.setText("Triangles");

        JButton circle = new JButton();
        circle.setText("Circles");

        JButton button = new JButton();
        button.setText("X");

        JPanel top = new JPanel();
        top.setSize(100, 40);
        top.add(start);
        //top.add(start2);
        top.add(rect);
        top.add(triangle);
        top.add(circle);
        top.add(button);

        add(top, BorderLayout.NORTH);

        view = new ViewPanel();
        add(view);


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.next();
            }
        });


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Points will be set randomly");
                onStartClickRandom();
            }
        });

        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Rectangles chosen");
                view.changeFigureType(4);
                //onStartClick();
            }
        });

        triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Triangles chosen");
                view.changeFigureType(3);
                //onStartClick();
            }
        });

        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Circles chosen");
                view.changeFigureType(2);
                //onStartClick();
            }
        });
        /*
        start2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "");
                //onStartClick();
            }
        });

        view.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int mouseX = e.getX(), mouseY = e.getY();
                onStartClick(mouseX, mouseY);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        */
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

        //EventQueue.invokeLater(new Runnable() {
        //    @Override
        //    public void run() {
        //        MainFrame frame = new MainFrame();
        //        frame.setVisible(true);
        //    }
        //});
    }

}
