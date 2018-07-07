/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class CareyBrownAtulMore {
    
}

class BreakPoint8
{
    private static final Test[] TESTS =
    {
        // sentence, criteria, expected
        new Test( (String)null, 12, -1 ),
        new Test( "", 12, -1 ),
        new Test( "message are", 0, -1 ),
        new Test( "message are", 501, -1 ),
        new Test( "messagemessages are", 12, -1 ),
        new Test( "Text", 12, 1 ),
        new Test( "Text message are", 12, 2 ),
        new Test( "Text message are good to read", 12, 3 ),
        new Test( "Twelevewords", 12, 1 ),
        new Test( "Twelevewords Text message are good to read", 12, 4 ),
        new Test( "Text Twelevewords message are good to read", 12, 4 ),
        new Test( "Text are Twelevewords messages and they are good to read", 12, 5 ),
        new Test( "Text", 3, -1 ),
        new Test( "Text message are", 7, 3 ),
        new Test( "My name is Atul More", 4, 5 ),
        new Test( "They all are in one flat", 4, 6 ),
        new Test( "if it is in", 2, 4 ),
        new Test( "if code it is in", 3, -1 )
    };
         
    public static void main( String[] args )
    {
        BreakPoint8         inst = new BreakPoint8();
        for( Test t : TESTS )
        {
            int result = inst.calculateBreakPoint8( t );
            if( result == t.expected )
                System.out.println( "SUCCESS " + t );
            else
                System.out.println( "FAILED  " + t + "   result was " + result );
        }
    }
 
    public int calculateBreakPoint8( Test test )
    {
        if( ! test.isValid() )
        {
            return -1;
        }
         
 
        SumCount result = Stream.of( test.sentence.split( "\\s+" ) )
                .map( s -> s.length() )
                .collect( () -> new SumCount(test.criteria), // SumCount::new, // *** wanted: new SubCount(test.criteria)
                        SumCount::add,
                        SumCount::addSumCount )
        ; // won't work in parallel so combiner not applicable
                 
        return result.getCount();
    }
     
//  Exception in thread "main" java.lang.NullPointerException
//  at java.base/java.util.Objects.requireNonNull(Objects.java:221)
//  at java.base/java.util.stream.ReduceOps.makeRef(ReduceOps.java:210)
//  at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:589)
//  at BreakPoint8.calculateBreakPoint8(BreakPoint8.java:55)
//  at BreakPoint8.main(BreakPoint8.java:36)
     
    //======================================================================
    class SumCount
    {
        int         criteria;
        int         sum = 0;
        int         count = 0;
         
        // dummy trying to get it to compile
        public SumCount()
        {
            this.criteria = 12;
        }
         
        public SumCount( int criteria )
        {
            this.criteria = criteria;
        }
         
        public void add( int len )
        {
            if( sum + len == criteria )
            {
                sum = 0;
                count++;
            }
            else if( sum + len > criteria )
            {
                sum = len;
                count++;
            }
            else
            {
                sum += len;
            }
        }
        
        public void addSumCount(SumCount other) {
            sum += other.sum;
        }
         
        public int getCount()
        {
            if( sum > 0 )
                count++;
            return count;
        }
    }
     
    //======================================================================
    private static class Test
    {
        String sentence;
        String[] words;
        int criteria;
        int expected;
 
        public Test( String sentence, int criteria, int expected )
        {
            this.sentence = sentence;
            if( sentence != null )
                this.words = sentence.split( "\\s+" );
            this.criteria = criteria;
            this.expected = expected;
        }
         
        @Override
        public String toString()
        {
            return "\"" + sentence + "\", " + criteria + ", " + expected;
        }
         
        public boolean isValid()
        {
            if( criteria <= 0 || criteria > 500 )
                return false;
             
            if( sentence == null || sentence.isEmpty() || sentence.trim().length() > 500 )
                return false;
 
            for( String w : words )
                if( w.length() > criteria )
                    return false;
 
            return true;
        }
    }
}
