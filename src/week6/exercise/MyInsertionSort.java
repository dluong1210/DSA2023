public class MyInsertionSort {
    public static void insertionSort(int[] arr, int left, int right) {
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
        int[] arr = new int[] {9, 2, 7, 4, 5, 6, 3, 8};

        insertionSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
