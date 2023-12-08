public class MySelectionSort {

    public static void selectionSort(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            int min = i;
            for (int j = i + 1; j <= r; j++) {
                if (arr[j] < arr[min]) min = j;
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] argv) {
        int[] arr = new int[] {5, 4, 3, 2, 1, 0};
        selectionSort(arr, 0, 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
