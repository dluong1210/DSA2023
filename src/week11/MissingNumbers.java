public class MissingNumbers {
    // Cach 1
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> check = new HashMap<>(10000);
        for (int i : brr) {
            check.putIfAbsent(i, 0);
            check.put(i, check.get(i) + 1);
        }
        
        for (int i : arr) {
            check.put(i, check.get(i) - 1);
        }
        
        for (int i : check.keySet()) {
            if (check.get(i) > 0) ans.add(i);
        }
        return ans;
    }

    // Cach 2
    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        Collections.sort(arr);
        Collections.sort(brr);
        
        List<Integer> ans = new ArrayList<>();
        int a = 0, b = 0;
        while (a < arr.size() || b < brr.size()) {
            if (a < arr.size() && arr.get(a).equals(brr.get(b))) {
                a++;
                b++;
            } else {
                ans.add(brr.get(b));
                b++;
                while (b < brr.size() && brr.get(b).equals(brr.get(b - 1))) b++;
            }
        }
        return ans;
    }

    // Cach 3
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        int temp = Collections.min(brr);
        int[] check = new int[100];
        for (int i : check) {
            i = 0;
        }
        
        for (int i : brr) {
            check[i - temp]++;
        }
        for (int i : arr) {
            check[i - temp]--;
        }
        
        for (int i = 0; i < 100; i++) {
            if (check[i] > 0) ans.add(i + temp);
        }
        
        return ans;
    }
}