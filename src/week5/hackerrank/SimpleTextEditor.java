import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<String> rmb = new Stack<>();
        String s = new String();
        int k;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            switch (scan.nextInt()) {
            case 1:
                rmb.push(s);
                String temp = scan.next();
                s += temp;
                break;
            case 2:
                rmb.push(s);
                k = scan.nextInt();
                s = s.substring(0, s.length() - k);
                break;
            case 3:
                k = scan.nextInt();
                System.out.println(s.charAt(k-1));
                break;
            case 4:
                s = rmb.pop();
            }
        }
    }
}
