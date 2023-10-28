public class Cookies {
    public static int cookies(int k, List<Integer> A) {
    // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < A.size(); i++) {
            q.add(A.get(i));
        }
        int ans = 0;  q.peek() < k) {
            int temp = q.poll() + 2 * q.poll();
            q.add(temp);
            ans++;
        }
        if (q.isEmpty()) return -1;
        return q.peek() < k ? -1 : ans;
    }
}