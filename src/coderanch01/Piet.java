/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.util.function.Consumer;

/**
 *
 * @author Piet
 */
public class Piet {
    public static void main(String... args) {
        new Piet().go();
    }
    
    private void go() {
//        Consumer<Integer> wrong = x -> 5;   // wrong
        Consumer<Integer> okay = this::return5;   // okay

    }

    private int return5(int x) {
        return 5;
    }
}
