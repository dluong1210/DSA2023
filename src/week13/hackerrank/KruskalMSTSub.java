public class KruskalMSTSub {
    public static int parent(int i, int[] arr) {
        while (i != arr[arr[i]]) {
            i = arr[arr[i]];
        }
        return i;
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        PriorityQueue<int[]> check = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[2], b[2]);
        });
        int ans = 0;
        int[] arr = new int[gNodes];
        for (int i = 0; i < gNodes; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < gFrom.size(); i++) {
            check.add(new int[]{gFrom.get(i), gTo.get(i), gWeight.get(i)});
        }
        
        for (int i = 0; i < gNodes - 1; i++) {
            while(parent(check.peek()[0] - 1, arr) == parent(check.peek()[1] - 1, arr)) {
                check.poll();
            }
            ans += check.peek()[2];
            arr[parent(check.peek()[0] - 1, arr)] = check.peek()[1] - 1;
            check.poll();
        }
        
        return ans;
    }
}