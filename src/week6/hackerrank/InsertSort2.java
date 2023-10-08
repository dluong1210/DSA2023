public class InsertSort2 {
    public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) > arr.get(j+1)) Collections.swap(arr, j, j + 1);
                else break;
            }
            for (int j = 0; j < n; j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
    }
}