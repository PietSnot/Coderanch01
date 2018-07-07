/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Piet
 */
public class TedGress {

}

class Difference {

    public static int Diff(int left, int right) {
        if (left >= right) {
            return left - right;
        } else {
            return right - left;
        }
    }

}

class InputRows {

    public static void inputRows() {
        System.out.println("Please enter row input");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;
        ArrayList<Integer> inputRow = new ArrayList<Integer>();

        try {
            inputLine = bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(inputLine);
        while (st.hasMoreTokens()) {
            String element = st.nextToken();
            inputRow.add(Integer.parseInt(element));
        }

        System.out.println("Input Complete");
        System.out.println("Input is Row is" + inputRow);

        NewtonsTriangle.entireTriangle.add(inputRow);
    }

}

class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<ArrayList<Integer>> al = new ArrayList();
        InputRows.inputRows();
        NewtonsTriangle.Triangle();
        OutputRows.outputRows();
    }

    private static ArrayList getAL() {
        return new ArrayList();
    }
}

class NewtonsTriangle {

    static ArrayList<ArrayList<Integer>> entireTriangle = new ArrayList<>();

    public static void Triangle() {
        //entire a list of integers into subrow
        //take returned integer from subrow and put it in subrow
        //repeat until done with lists

        System.out.println("Calculating Triangle");
        //iterate over rows

//        ArrayList<Integer> rows = entireTriangle.get(0);
//        for (int i = 0; i < rows.size(); i++) {
        for (int i = 0; i < entireTriangle.get(0).size(); i++) {
            ArrayList<Integer> rows = entireTriangle.get(i);
            if (rows.size() < 2) continue;
            ArrayList<Integer> row = SubtractRow.SubRow(rows);
            entireTriangle.add(row);
        }
        System.out.println("Triangle Calculated");
    }

}

class OutputRows {

    public static void outputRows() {
        System.out.println("Outputting Rows");
        System.out.println("Triangle Size " + NewtonsTriangle.entireTriangle.size());

        for (ArrayList<Integer> rows : NewtonsTriangle.entireTriangle) {
//            System.out.println(rows.size() + " rows calculated");
            for (int i = 0; i < rows.size(); i++) {
                //a single row
                System.out.print(" " + rows.get(i) + " ");
            }
            System.out.println();
        }
    }

}

class SubtractRow {

    public static ArrayList<Integer> SubRow(List<Integer> row) {
        ArrayList<Integer> newRow = new ArrayList<Integer>();

        if (row.size() == 1) return newRow;
        
        Integer first = row.get(0);

        Integer second = row.get(1);

        newRow.add(Difference.Diff(first, second));

        if (row.size() == 2) return newRow;
        
        Integer last = second;

        Integer next = null;

        for (int i = 2; i < row.size(); i++) {

            next = row.get(i);

            Integer diff = Difference.Diff(last, next);

            last = next;

            newRow.add(diff);

        }

        return newRow;

    }

}
