public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        int ans = 0;
        Set<Integer> check = new HashSet<>();
        Collections.sort(arr);
        for(int i = 0 ;i < arr.size(); i++) {
            check.add(arr.get(i));
            if(check.contains(arr.get(i) - k)) ans++;
        }
        return ans;
    }
}