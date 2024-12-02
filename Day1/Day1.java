import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Day1 {
    public static void main(String[] args) {
        int lines = 0;
        try {
            File inputFile = new File("Day1/day1Input.txt");
            Scanner lineCounter = new Scanner(inputFile);
            while (lineCounter.hasNextLine()) {
                lineCounter.nextLine();
                lines++;
            }
            lineCounter.close();

            int[] arr1 = new int[lines];
            int[] arr2 = new int[lines];

            Scanner myReader = new Scanner(inputFile);
            for (int i = 0; i < lines; i++) {
                arr1[i] = myReader.nextInt();
                arr2[i] = myReader.nextInt();
            }
            myReader.close();
            // There is now two arrays:
            // arr1: first column's numbers
            // arr2: second column's numbers

            System.out.println("Difference:" + getDifferences(arr1, arr2));
            System.out.println("Similarity Score:" + getSimilarityScore(arr1, arr2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getDifferences(int[] arr1, int[] arr2) {
        int sum = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.abs((arr1[i] - arr2[i]));
        }
        return sum;
    }

    public static int getSimilarityScore(int[] arr1, int[] arr2) {
        int similarityScore = 0;
        for (int i = 0; i < arr1.length; i++) {
            int tmp = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr2[j]) tmp++;
            }
            similarityScore += tmp * arr1[i];
        }
        return similarityScore;
    }
}
