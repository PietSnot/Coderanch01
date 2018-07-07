/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class StevenGreenbaum {

    public static void main(String... args) {
        String timeseriesdateStart = "2017-06-30";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("y-M-d");
        int periods = 60;
        LocalDate[] timeSeries = new LocalDate[periods];
        LocalDate[] timeSeries2;

        LocalDate start = LocalDate.parse(timeseriesdateStart, dtf);
        for (int j = 0; j < timeSeries.length; j++) {
            timeSeries[j] = start.plusMonths(j);
        }
//        timeSeries2 = Stream.<LocalDate>iterate(start, s -> s.).limit(60).toArray(LocalDate[]::new);
        Arrays.asList(timeSeries).forEach(System.out::println);
        System.out.println("**********************************");
//        Arrays.asList(timeSeries2).forEach(System.out::println);
    }
}
