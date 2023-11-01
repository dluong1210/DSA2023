import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> count = new TreeMap<>();
        String[] word = scan.nextLine().split(" ");

        for (String s : word) {
            if (!count.containsKey(s)) count.put(s, 1);
            else count.put(s, count.get(s) + 1);
        }

        for (String s : count.keySet()) {
            System.out.println(s + " " + count.get(s));
        }
    }
}
