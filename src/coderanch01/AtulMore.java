/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class AtulMore {
    public static void main(String... args) {
//        String s = "Use of Java8 Streams is not easy or handy, although it makes for some good exercise";
        String s = "message are";
        if (!s.endsWith(" ")) s += " ";
        TreeSet<Integer> spaces = getIndicesOfSpaces(s);
        int maxBreak = 501;
        if (cannotBreak(spaces, maxBreak)) throw new RuntimeException("Can't break the string");
        TreeSet<Integer> breaks = getBreaks(spaces, maxBreak);
        System.out.println(breaks);
        System.out.println("Number of breaks: " + breaks.size());
//        breaks.forEach(i -> System.out.println(s.substring(i)));
        for (int i: breaks) System.out.println(s.substring(0, i));
    }
    
    private static TreeSet<Integer> getIndicesOfSpaces(String s) {
        TreeSet<Integer> result = IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == ' ')
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new))
        ;
        return result;
    }
    
    private static TreeSet<Integer> getBreaks(TreeSet<Integer> set, int maxBreak) {
        int[] temp = {0};
        TreeSet<Integer> result = set.stream()
                .map(i -> {int p = temp[0] + maxBreak; int q = set.floor(p); temp[0] = q; return q;})
                .collect(Collectors.toCollection(TreeSet::new))
        ;
        return result;
    }
                
    private static boolean cannotBreak(Set<Integer> s, int criterium) {
        int[] temp = {0};
        return s.stream().anyMatch(i -> {int p = temp[0]; temp[0] = i; return i - p > criterium;}); 
    }
}