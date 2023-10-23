import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import edu.princeton.cs.algs4.Stopwatch;

public class MyQuickSort {
    public static void swap(Comparable[] arr, int a, int b) {
        if (a == b) return;
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(Comparable[] arr, int lo, int hi) {
        int mid = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i].compareTo(arr[hi]) < 0) {
                if (i != mid) {
                    swap(arr, i, mid);
                }
                mid++;
            }
        }
        swap(arr, hi, mid);
        return mid;
    }

    public static int[] partitionKeyEquals(Comparable[] arr, int lo, int hi) {
        int lt = lo, gt = hi;
        Comparable pivot = arr[lo];

        for (int i = lo + 1; i <= gt; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                swap(arr, i, lt);
                lt++;
            } else if (arr[i].compareTo(pivot) > 0) {
                while (arr[gt].compareTo(pivot) > 0 && gt > i) {
                    gt--;
                }
                swap(arr, i, gt);
                gt--;
                i--;
            }
        }
        return new int[] {lt, gt};
    }

    public static int[] partition3Way(Comparable[] arr, int lo, int hi) {
        int lt = lo, gt = hi;
        if (arr[lo].compareTo(arr[hi]) > 0) swap(arr, hi, lo);
        Comparable pivot1 = arr[lo], pivot2 = arr[hi];

        for (int i = lo + 1; i < gt; i++) {
            if (arr[i].compareTo(pivot1) < 0) {
                swap(arr, i, lt++);
            } else if (arr[i].compareTo(pivot2) > 0) {
                while (gt > i && arr[gt].compareTo(pivot2) > 0) gt--;
                swap(arr, i, gt--);
                i--;
            }

        }
        return new int[] {lt, gt};
    }

    public static void quickSortBasic(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = partition(arr, lo, hi);

//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j] + " ");
//        }
//        System.out.println();

        quickSortBasic(arr, lo, mid - 1);
        quickSortBasic(arr, mid + 1, hi);
    }

    public static void quickSortKeyEquals(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int[] temp = new int[2];
        temp = partitionKeyEquals(arr, lo, hi);

//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j] + " ");
//        }
//        System.out.println();

        quickSortKeyEquals(arr, lo, temp[0] - 1);
        quickSortKeyEquals(arr, temp[1] + 1, hi);
    }

    public static void quickSort3Way(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int[] temp = partition3Way(arr, lo, hi);

        if (arr[temp[0]].compareTo(arr[temp[1]]) != 0) quickSort3Way(arr, temp[0] + 1, temp[1] - 1);
        quickSort3Way(arr, lo, temp[0] - 1);
        quickSort3Way(arr, temp[1] + 1, hi);
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<>();
        try {
            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\8Kints.txt");
            Scanner scan = new Scanner(ip);
            while (scan.hasNext()) {
                arr.add(scan.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Integer[] test = new Integer[arr.size()];
        test = arr.toArray(test);
//        for (int i = 0; i < 8000; i ++) test[i] = 8000 - i;
        Stopwatch stopwatch;

        // Test quick sort basic
        stopwatch = new Stopwatch();
        quickSortKeyEquals(test, 0, test.length - 1);
        System.out.println("Time run quicksort basic: " + (double)stopwatch.elapsedTime() + "s");
        for (int i = 0; i < 8000; i++) {
            if (test[i] != i + 1) {
                System.out.println("false test1");
                break;
            }
        }

        // Test quick sort with duplicate keys
        stopwatch = new Stopwatch();
        quickSortBasic(test, 0, test.length - 1);
        System.out.println("Time run quicksort key equals: " + (double)stopwatch.elapsedTime() + "s");
        for (int i = 0; i < 8000; i++) {
            if (test[i] != i + 1) {
                System.out.println("false test2");
                break;
            }
        }

        // Test quick sort 3-way
        stopwatch = new Stopwatch();
        quickSort3Way(test, 0, test.length - 1);
        System.out.println("Time run quicksort 3-way: " + (double)stopwatch.elapsedTime() + "s");
        for (int i = 0; i < 8000; i++) {
            if (test[i] != i + 1) {
                System.out.println("false test3");
                break;
            }
        }
    }
}
