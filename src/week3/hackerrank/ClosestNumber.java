public class ClosestNumber {
    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        int mini = Integer.MAX_VALUE;
        Collections.sort(arr);
        List<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<arr.size()-1 ; i++) {
            if( arr.get(i+1) - arr.get(i) < mini ) {
                mini = arr.get(i+1) - arr.get(i);
                ans.clear();
                ans.add(arr.get(i));
                ans.add(arr.get(i+1));
            }
            else if( arr.get(i+1)-arr.get(i) == mini ) {
                ans.add(arr.get(i));
                ans.add(arr.get(i+1));
            }
        }
        return ans;
    }
}