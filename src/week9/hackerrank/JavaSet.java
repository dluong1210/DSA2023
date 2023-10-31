import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaSet {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
        Set<String> temp = new HashSet<>();
        int count = 0;
        for (int i = 0; i < t; i++) {
            if (!temp.contains(pair_left[i] + " " +  pair_right[i])) {
                temp.add(pair_left[i] + " " + pair_right[i]);
                count++;
            }
            System.out.println(count);
        }
   }
}