/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.geom.Path2D;

/**
 *
 * @author Piet
 */
public class GregPosey {
    public static void main(String... args) {
        Path2D path = new Path2D.Double();
        path.moveTo(0, 0);
//        path.moveTo(0, 1);
//        path.moveTo(1, 1);
//        path.moveTo(1, 0);
        path.lineTo(0, 1);
        path.lineTo(1, 1);
        path.lineTo(1, 0);
        path.closePath();
        path.setWindingRule(Path2D.WIND_EVEN_ODD);
        System.out.println("path contains (.5, .5) ? W_E_O? " + path.contains(.5, .5));
        System.out.println("path contains (2, 2) ? W_E_O? " + path.contains(2, 2));
        path.setWindingRule(Path2D.WIND_NON_ZERO);
        System.out.println("path contains (.5, .5) ? W_N_Z " + path.contains(.5, .5));
        System.out.println("path contains (2, 2) ? W_N_Z? " + path.contains(2, 2));
    }
}
