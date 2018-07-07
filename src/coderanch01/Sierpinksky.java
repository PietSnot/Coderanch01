/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Piet
 */
public class Sierpinksky {
    List<Point2D> points = new ArrayList<>();
    JPanel panel;
    enum Status {NOT_STARTED, BUSY, FINISHED}
    Status status = Status.NOT_STARTED;
    Timer timer;
    
    public static void main(String... args) {
        int nrOfPoints = 50_000;
//        new Sierpinksky().draw();
    }
    
    public Sierpinksky() {
        int width = 800, height = 800;
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.RED);
                points.forEach((p -> g2d.drawLine(p.getX(), p.getY(), p.getX(), p.getY())));
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };
        JFrame frame = new JFrame("Sierpinsky");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
}
