/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Piet
 */
public class JeremyWatts {
    
    public static void main(String... args) {
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 2, 5, 5));
        for (int i = 1; i <= 11; i++) {
            p.add(new JTextField(6));
        }
        p.setBackground(Color.yellow);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JFrame frame = new JFrame();
        Container c = frame.getContentPane();
        c.add(p, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
