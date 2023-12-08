public class FindRunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        List<Double> ans = new ArrayList<>();
        int left = 0, right = 0;
        int median = -1;
        TreeMap<Integer, Integer> temp = new TreeMap<>();
        
        for (int num : a) {
            if (median == -1) {
                median = num;
                temp.put(num, 1);
                ans.add((double) num);
                continue;
            }
            temp.putIfAbsent(num, 0);
            temp.put(num, temp.get(num) + 1);
            if (num < median) {
                left++;
            } else if (num > median) {
                right++;
            }
            if (left == right) {
                ans.add((double) median);
                continue;
            }

            while (right - left > temp.get(median)) {
                left += temp.get(median);
                median = temp.higherKey(median);
                right -= temp.get(median);
            }
            while (left - right > temp.get(median)) {
                right += temp.get(median);
                median = temp.lowerKey(median);
                left -= temp.get(median);
            }
            
            if ((right + left + temp.get(median)) % 2 == 0) {
                if (right - left == temp.get(median)) ans.add((double)(median + temp.higherKey(median)) / 2);
                else if (left - right == temp.get(median)) ans.add((double)(median + temp.lowerKey(median)) / 2);
                else ans.add((double) median);
                
            } else {
                ans.add((double) median);
            }
        }
        
        return ans;
    }
}