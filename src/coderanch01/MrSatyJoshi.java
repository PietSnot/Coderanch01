/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

/**
 *
 * @author Piet
 */
public class MrSatyJoshi {
    
}

class C <E extends C> {
     
    E inC;
    public C doStuff(E e, C<E> e2){
        return e.getE();
    }
    public E getE(){
        return inC;
    }
    
//    public static void main(String... args) {
//        E e = new E();
//        C<E> p = new C<E>();
//    }
}

class E extends C {}