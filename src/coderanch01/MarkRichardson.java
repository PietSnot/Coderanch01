/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.util.Scanner;

/**
 *
 * @author Piet
 */
public class MarkRichardson {
    
}

class EndOfCalculation {
 
    public static void main(String... args) {
         
        byte finalWish;
 
        System.out.println();
        System.out.println("enter 1 to start over, 2 to exit");
 
        Scanner input = new Scanner(System.in);
        finalWish =  input.nextByte();
         
 
        switch (finalWish) {
        case 1: {
            System.out.println("1 chosen");
        }
        case 2: {
            System.exit(0); // exit success
        }
 
        }
 
    }
}
