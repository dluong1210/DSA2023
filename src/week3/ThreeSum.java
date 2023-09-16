package src.week3;

import edu.princeton.cs.algs4.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {
    public static List<List<Integer>> threeSum( List<Integer> arr, int k ) {
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr.get(i).equals(arr.get(i + 1))) continue;
            int need = k - arr.get(i);
            int l = 0, r = arr.size() - 1;
            while (l < r) {
                if( arr.get(l) + arr.get(r) == need) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(l);
                    temp.add(r);
                    ans.add(temp);
                }
                else if (arr.get(l) + arr.get(r) < need) {
                    l++;
                }
                else {
                    r++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)  {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            arr.add(StdIn.readInt());
        }
        StdOut.println(threeSum(arr, 0));
    }
}
