/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Piet
 */
public class PaulAdams {
    public static void main(String... args) {
        JFrame f = new JFrame("Hoeperdepoep zat op de stoep");
        ImageIcon icon = new ImageIcon("G:/test.png");
        f.setIconImage(icon.getImage());
        JLabel label = new JLabel(icon);
        f.add(label);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
