public class EqualStack {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < h1.size() ; i++) {
            sum1 += h1.get(i);
        }
        for (int i = 0; i < h2.size() ; i++) {
            sum2 += h2.get(i);
        }
        for (int i = 0; i < h3.size() ; i++) {
            sum3 += h3.get(i);
        }
        
        while (sum1 != 0 && sum2 != 0 && sum3 != 0) {
            int mini = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 == mini && sum2 == mini && sum3 == mini) return mini;
            if (sum1 > mini) {
                sum1 -= h1.get(i1);
                i1++;
            }       
            if (sum2 > mini) {
                sum2 -= h2.get(i2);
                i2++;
            }
            if (sum3 > mini) {
                sum3 -= h3.get(i3);
                i3++;
            }
        }
        return 0;
    }
}