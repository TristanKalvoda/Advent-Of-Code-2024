import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.math;

public class Day1 {
    public static void main(String[] args) {
        int lines = 0;
        try {
            File inputFile = new File("day1Input.txt");
            Scanner lineCounter = new Scanner(inputFile);
            while (lineCounter.hasNextLine()) {
                lineCounter.nextLine();
                lines++;
            }
            lineCounter.close();

            int[] arr1 = new int[lines];
            int[] arr2 = new int[lines];

            Scanner myReader = new Scanner(inputFile);
            // while (myReader.hasNextLine()) {
            // System.out.println("arr1:" + myReader.nextInt());
            // System.out.println("arr2:" + myReader.nextInt());
            // }
            for (int i = 0; i < lines; i++) {
                arr1[i] = myReader.nextInt();
                arr2[i] = myReader.nextInt();
            }
            myReader.close();
            // There is now two arrays: 
            // arr1: first column's numbers
            // arr2: second column's numbers

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            //Arrays are now Sorted

            getDifferences(arr1,arr2);
            System.out.println(getDifferences(arr1, arr2));

            
            // System.out.println(Arrays.toString(arr1));
            // System.out.println(Arrays.toString(arr2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getDifferences(int[] arr1, int[] arr2){
        int sum = 0;
        for(int i = 0; i<arr1.length; i++) {
            sum += Math.abs((arr1[i]-arr2[i]));
        }
        return sum;
    }
}
