package week2;

// import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class TwoSum {
    public static void twoSum(ArrayList<Integer> arr, int k) {
        Collections.sort(arr);
        HashSet<Integer> temp = new HashSet<Integer>(1000);
        for (int i = 0; i < arr.size(); i++) {
            if (temp.contains(k - arr.get(i))) {
                System.out.println((k - arr.get(i)) + " " + arr.get(i));
            }
            temp.add(arr.get(i));
        }
    }

    public static void main(String[] argv) {
        File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\1Kints.txt");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try {
            Scanner scan = new Scanner(ip);
            while (scan.hasNextLine()) {
                arr.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        twoSum(arr, 0);
    }
}