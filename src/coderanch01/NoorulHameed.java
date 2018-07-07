/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 *
 * @author Piet
 */
public class NoorulHameed {

}

class LambdaTest {

    public static void main(String[] args) {
//        List<String>[] table; // Error
//        table = new List[10];
//        ArrayList[] objarray = new ArrayList[10];
//        objarray[0] = new ArrayList<String>();
//        objarray[0] = Arrays.asList("ArrayList", "is", "a", " Class");
//        System.out.println(objarray[0]);

        List[] table = new ArrayList[10];
        ArrayList[] objarray = new ArrayList[10];
        System.out.println(table.length);
        objarray[0] = new ArrayList<String>();
        // java.lang.ArrayStoreException
        //objarray[0] = Arrays.asList("List", "is", "an", "abstract and interface");
objarray[1] = Arrays.asList("List", "is", "an", "abstract and interface").stream().collect(toCollection(ArrayList::new));
((List<Point>) objarray[1]).add(new Point());
System.out.println(objarray[1]);
//        objarray[2] = new ArrayList<Integer>();
//        ((ArrayList<String>) objarray[2]).add("Piet")  ;  //.add(new Integer(10));
//        ((ArrayList) objarray[2]).add(new Point());
//        System.out.println(Arrays.toString(objarray));
//        ArrayList[] c = new ArrayList[10];
//        c[0] = new ArrayList<String>();
//        c[0].add(new Point());
//        System.out.println(c[0]);
    }
}
