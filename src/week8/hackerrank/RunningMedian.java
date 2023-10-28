public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((b, c) -> c - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((b, c) -> b - c);
        List<Double> ans = new ArrayList<>();
        
        for (int i = 0; i < a.size(); i++) {
            if (!maxHeap.isEmpty() && a.get(i) >= maxHeap.peek()) {
                maxHeap.add(a.get(i));
            }
            else minHeap.add(a.get(i));
            
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            
            if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
                ans.add((double) (maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek()));
            }
            else {
                ans.add((double) (maxHeap.peek() + minHeap.peek()) / 2);
            }
        }
        return ans;
    }
}