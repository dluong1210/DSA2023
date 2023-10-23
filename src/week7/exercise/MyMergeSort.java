import edu.princeton.cs.algs4.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

public class MyMergeSort {
    public int[] mergeSort(int[] arr, int size) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, size - 1);
        return arr;
    }

    private void sort(int[] arr, int[] temp, int left, int right) {
        if (right - left <= 100) {
            insertionSort(arr, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, temp, left, mid);
        sort(arr, temp, mid + 1, right);
        merge(arr, temp, left, right, mid);
    }

    private void merge(int[] arr, int[] temp, int left, int right, int mid) {
        int i1 = left, i2 = mid + 1;
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        for (int i = left; i <= right; i++) {
            if (i1 == mid + 1 || (i2 <= right && temp[i1] > temp[i2])) arr[i] = temp[i2++];
            else arr[i] = temp[i1++];
        }
    }

    public void insertionSort(int[] arr, int left, int right) {
        for (int i = right; i > left; i--) {
            if (arr[i] > arr[i-1]) continue;
            for (int j = i; j <= right; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else break;
            }
        }
    }

    public static void main(String[] argv) {
        int[] test = new int[] {9, 2, 7, 4, 5, 6, 3, 8};
        int size = 0, n = 100000000;
        int[] arr = new int[n];
        try {
            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\32kints.txt");
            Scanner scan = new Scanner(ip);
            while (scan.hasNext()) {
                arr[size] = scan.nextInt();
                size++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MyMergeSort testSort = new MyMergeSort();
        Stopwatch stopwatch = new Stopwatch();
        testSort.mergeSort(arr, size);
        System.out.println("Time run(s): " + stopwatch.elapsedTime());
        for (int i = 0; i < size; i++) {
//            System.out.print(arr[i] + " ");
            if (i > 0 && arr[i] - arr[i-1] < 0) {
                System.out.println("False at index: " + i);
                break;
            }
        }
        System.out.println(size);
    }
}
