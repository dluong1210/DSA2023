public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.get(i) > arr.get(i-1) ) continue;
            int temp = arr.get(i);
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr.get(j - 1) >= temp) {
                    arr.set(j, arr.get(j - 1));
                    for (int k = 0; k < arr.size(); k++) {
                        System.out.print(arr.get(k) + " ");
                    }
                    System.out.print('\n');
                } else {
                    arr.set(j, temp);
                    for (int k = 0; k < arr.size(); k++) {
                        System.out.print(arr.get(k) + " ");
                    }
                    System.out.print('\n');
                    break;
                }
            }
        }
    }
}