public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        int l = 0, r = 1, ans = 0;
        Collections.sort(arr);
        for (r = 1; r < arr.size(); r++) {
            while (l < r) {
                int temp = arr.get(r) - arr.get(l);
                
                if (temp < k) break;
                if (temp == k) ans++;
                l++;
            }
        }
        return ans;
    }

}