/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class Coderanch01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        try (
//            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
//            Statement stmt = con.createStatement()
//        ) { 
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
        
        Rectangle2D rec = new Rectangle2D.Double(0, 0, 100, 50);
        AffineTransform at = AffineTransform.getRotateInstance(Math.PI * 2 / 8);
        Path2D p = new Path2D.Double(rec, at);
        Rectangle2D boundingBox = p.getBounds2D();
        System.out.format("width: %7.2f, height: %7.2f%n%n", boundingBox.getWidth(), boundingBox.getHeight());
        
        class MaxKeeper {
            int max;
            boolean firstTime = true;
            public boolean isMax(int n) {
                if (firstTime || n > max) {
                    max = n;
                    if (firstTime) firstTime = false;
                    return true;
                }
                else return false;
            }
        }
        
        boolean fromLeft = true;
        MaxKeeper maxkeeper = new MaxKeeper();
        List<Integer> list = Arrays.asList(12, 24, 54, 26, 27, 2, 98, 16);
        List<Integer> max = IntStream.range(0, list.size())
                .mapToObj(i -> list.get(fromLeft ? i : list.size() - 1 - i))
                .filter(maxkeeper::isMax)
                .collect(Collectors.toList())
        ;
        System.out.println(list);
        System.out.println(max);
        ;
        
        FeestNeus piet = (a, b) -> a.charAt(b);
        System.out.println(piet.apply("Feestneus", 5));
    }
    
}

interface FeestNeus extends BiFunction<String, Integer, Character> {}   

