/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class ArpanGhoshal {
    
    public static void main(String... args) {
        List<Point> points = Arrays.asList(new Point(), new Point());
        method(points);
        BiFunction<String, Integer, Character> f = String::charAt;
        class A {};
        String s = "Arpan";
        long t = IntStream.of(2, 3).map(s::charAt).count();
        
        
    }
    
    public static void method(Collection<?> a) {
        System.out.println(a.size());
    }
    
    BitFunction<Integer, String, String> bitf = (Integer a, String b) -> b + a;

    interface BitFunction<A, B, C> {
        C apply(A a, B b);
    }
    
}

