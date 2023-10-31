public class ClosestNumber {
    public static void merge(List<Integer> temp, List<Integer> arr, int lo, int hi, int mid) {
        for (int i = lo; i <= hi; i++) {
            arr.set(i, temp.get(i));
        }
        
        int l = lo, h = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (h > hi || (l <= mid && arr.get(l) < arr.get(h))) temp.set(i, arr.get(l++));
            else temp.set(i, arr.get(h++));
        }
    }
    
    public static void sort(List<Integer> arr, List<Integer> temp, int lo, int hi) {
        if (lo >= hi) return;
        
        int mid = lo + (hi - lo) / 2;
        sort(arr, temp, lo, mid);
        sort(arr, temp, mid + 1, hi);
        
        merge(arr, temp, lo, hi, mid);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        List<Integer> temp = new ArrayList<>();
        
        for (int i : arr) temp.add(i);
        
        sort(arr, temp, 0, arr.size() - 1);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (ans.isEmpty() || arr.get(i) - arr.get(i - 1) < ans.get(1) - ans.get(0)) {
                ans.clear();
                ans.add(arr.get(i - 1));
                ans.add(arr.get(i));
            }
            else if (arr.get(i) - arr.get(i - 1) == ans.get(1) - ans.get(0)) {
                ans.add(arr.get(i - 1));
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}