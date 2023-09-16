package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearch {
    public static int binarySearch(List<Integer> arr, int k) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == k) {
                return mid;
            } else if (arr.get(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(mid);
        }
        return -1;
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<Integer>();
        Random rand = new Random();
        File testCase = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\largeT.txt");
        try {
            Scanner scan = new Scanner(testCase);
            for (int i = 0; i < Integer.valueOf(argv[0]); i++) {
                arr.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(arr);
        int k = arr.get(rand.nextInt(arr.size()));
        int ans = binarySearch(arr, k);
        if (ans != -1) {
            System.out.println("index of number: " + ans);
        } else {
            System.out.println("Dont exist.");
        }
    }
}
