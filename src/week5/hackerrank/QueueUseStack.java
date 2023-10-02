import java.io.*;
import java.util.*;

public class QueueUseStack {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> newStk = new Stack<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int req = scan.nextInt();
            switch (req) {
            case 1:
                int x = scan.nextInt();
                newStk.push(x);
                break;
            case 2:
                if (stk.isEmpty()) {
                    while (!newStk.isEmpty()) {
                        stk.push(newStk.pop());
                    }
                }
                stk.pop();
                break;
            case 3:
                if (stk.isEmpty()) {
                    while (!newStk.isEmpty()) {
                        stk.push(newStk.pop());
                    }
                }
                System.out.println(stk.peek());
            }
        }
    }
}
