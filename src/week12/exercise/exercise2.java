import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class exercise2 {
    public static List<int[]> solve(List<Integer> arr, int target) {
        List<int[]> ans = new ArrayList<>();
        Hashtable<Integer, Integer> check = new Hashtable<>();

        for (int a : arr) {
            if (check.containsKey(target - a) && check.get(target - a) > 0) {
                ans.add(new int[]{target - a, a});
                check.put(target - a, check.get(target - a) - 1);
            } else {
                check.putIfAbsent(a, 0);
                check.put(a, check.get(a) + 1);
            }
        }

        return ans;
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);

        for (int[] a : solve(arr, 10)) {
            System.out.println("(" + a[0] + ", " + a[1] + ")");
        }
    }
}
