import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class exercise1 {
    public static int solve(List<Integer> arr) {
        int sum = 0, start = 0, maxi = 0;
        Hashtable<Integer, Integer> temp = new Hashtable<>();

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);

            if (arr.get(i) > sum) {
                sum = arr.get(i);
                start = i;
            }

            maxi = Math.max(maxi, sum);
            temp.put(sum, start);
        }

        return maxi;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-2);
        arr.add(3);
        arr.add(-1);
        arr.add(2);
        arr.add(-4);
        arr.add(2);
        arr.add(3);

        System.out.println(solve(arr));
    }
}
