import java.io.*;
import java.util.*;

public class StringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if (A.length() == 1) System.out.println("Yes");
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                System.out.println("No");
                break;
            }
            if (i == A.length() / 2 - 1) System.out.println("Yes");
        }
    }
}



