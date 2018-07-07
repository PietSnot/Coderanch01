/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Piet
 */
public class RotatedImage {
    
    //===============================
    // members
    //===============================
    BufferedImage original, rotated;
    
    //===============================
    // constructor
    //===============================
    
    //===============================
    // public methods
    //===============================
    
    //===============================
    // private methods
    //===============================
    static int size = 10_000;
    static List<Integer> list = new ArrayList<>();
    static CyclicBarrier bar = new CyclicBarrier(size, () -> System.out.println("size: " + list.size()));
    
    public static void main(String... args) throws Exception {
//        URI uri = new URI("http://members.ziggo.nl/pietmuis/");
//        System.out.println(uri);
//        System.out.println(uri.getScheme());
//        System.out.println(uri.getSchemeSpecificPart());
//        FileSystem fs = FileSystems.getFileSystem(uri);
//        IntStream.range(0, 100_000).forEach(i -> SwingUtilities.invokeLater(getRunnable(i)));
        Thread.sleep(1_000);
        System.out.format("size: %,d%n", list.size());
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) < list.get(i - 1))
                System.out.println("fout voor i = " + i);
          
    }
    
//    static Runnable getRunnable(int i) {
//        return 
//            try {
//                () -> list.add(i);
//                bar.await();
//            }
//        }
//        catch (Exception e) {
//            return () -> System.out.println("error for i = " + i);
//        }
//    }
}
