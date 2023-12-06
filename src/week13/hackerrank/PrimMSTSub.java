public class PrimMSTSub {
    public static PriorityQueue<List<Integer>> temp = new PriorityQueue<>((a, b) -> {
        return Integer.compare(a.get(2), b.get(2));
    });
    
    public static void add(int start, List<List<Integer>> edges, boolean[] arr) {
        if (arr[start - 1]) return;
        int count = 0;
        for (List<Integer> e : edges) {
            if ((e.get(0) == start && !arr[e.get(1) - 1]) || (e.get(1) == start && !arr[e.get(0) - 1])) {
                temp.add(e);
                count++;
            }
        }
        arr[start - 1] = true;
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
        int ans = 0;
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = false;
        }

        add(start, edges, arr);
        for (int i = 0; i < n - 1; i++) {
            while (arr[temp.peek().get(0) - 1] && arr[temp.peek().get(1) - 1]) {
                temp.poll();
            }
            ans += temp.peek().get(2);
            
            List<Integer> a = temp.poll();
            add(a.get(0), edges, arr);
            add(a.get(1), edges, arr);
        }
        return ans;
    }
}