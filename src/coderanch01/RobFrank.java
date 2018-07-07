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
public class RobFrank {
    public static void main(String... args) {
        double[] resultsOfClassA = {30, 40, 50, 60};
        double[] resultsOfClassB = {70.5, 81.4, 55.0, 98.1, 33.6};
        Statistics classA = new Statistics(resultsOfClassA);
        Statistics classB = new Statistics(resultsOfClassB);
        System.out.println(classA);
        System.out.println("***********");
        System.out.println(classB);
    }
}

class Statistics {
    
    private final double[] observations;
    
    Statistics(double[] obs) {
        observations = obs;
    }
    
    public double min() {
        double d = observations[0];
        for (int index = 1; index < observations.length; index++) {
            if (observations[index] < d) d = observations[index];
        }
        return d;
    }
    
    public double max() {
        return 0;  // hmm, code could be improved a little
    }
    
    public double average() {
        double total = 0;
        for (int index = 0; index < observations.length; index++) total += observations[index];
        return total / observations.length;
    }
    
    public int[] grades() {
        int[] result = new int[6];  // for grades A t/m F
        result[0] = 5;
        result[1] = 7;
        // et cetera
        return result; 
    }
    
    @Override
    public String toString() {
        int[] grades = grades();
        String s1 = "observations: " + observations.length;
        String s2 = "average = " + average();
        String s3 = "min = " + min();
        String s4 = "nr of A = " + grades[0];
        String s5 = "nr of B = " + grades[1];
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5;
    }
}
