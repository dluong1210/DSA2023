import java.io.*;
import java.util.*;

public class QuickSortInPlace {
    public static int partition(List<Integer> arr, int l, int r) {
        if (l >= r) return -1;
        int slow = l;
        for (int i = l; i < r; i++) {
            if (arr.get(i) < arr.get(r)) {
                if (slow != i) Collections.swap(arr, slow, i);
                slow++;
            }
        }
        Collections.swap(arr, slow, r);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        return slow;
    }

    public static void quickSort(List<Integer> arr, int l, int r) {
        if (l >= r) return;
        int mid = partition(arr, l, r);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid + 1, r);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(scan.nextInt());
        }

        quickSort(arr, 0, arr.size() - 1);
    }
}