public class SherlockArray {
    public static String balancedSums(List<Integer> arr) {
    // Write your code here
        int sum = 0;
        for(int i=0 ; i<arr.size() ; i++) {
            sum += arr.get(i);
        }
        int left = 0, right = sum - arr.get(0);
        for(int i=1 ; i<arr.size() ; i++) {
            if( left == right ) return "YES";
            right -= arr.get(i);
            left += arr.get(i-1);
        }
        if( left == right ) return "YES";
        return "NO";
    }
}