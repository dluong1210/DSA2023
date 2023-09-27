package src.week3;

// import edu.princeton.cs.algs4.*;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {
    public static int threeSum(List<Integer> arr, int k) {
        int count = 0;
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr.get(i).equals(arr.get(i + 1))) continue;
            int need = k - arr.get(i);
            int l = 0, r = arr.size() - 1;
            while (l < r) {
                if ( arr.get(l).equals(arr.get(l+1))) {
                    l++;
                    continue;
                }
                if (arr.get(r).equals(arr.get(r - 1))) {
                    r--;
                    continue;
                }
                if( arr.get(l) + arr.get(r) == need) {
                   System.out.println(arr.get(i) + " " + arr.get(l) + " " + arr.get(r));
                   count++;
                   l++;
                   r--;
                }
                else if (arr.get(l) + arr.get(r) < need) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        try {
            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\32Kints.txt");
            Scanner scan = new Scanner(ip);
            while (scan.hasNext()) {
                arr.add(scan.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Total " + threeSum(arr, 0) + " 3-Sum.");
    }
}
