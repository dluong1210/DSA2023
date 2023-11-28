public class BFSShortReach {
        public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }
        ans.set(s - 1, 0);
        Queue<Integer> temp = new LinkedList();
        temp.add(s);
        while(!temp.isEmpty()) {
            int a = temp.poll();
            for (int i = 0; i < m; i++ ){
                if (edges.get(i).get(1) == a) Collections.swap(edges.get(i), 0, 1);
                if (edges.get(i).get(0) == a) {
                    if (ans.get(edges.get(i).get(1) - 1) == -1) {
                        temp.add(edges.get(i).get(1));
                        ans.set(edges.get(i).get(1) - 1, ans.get(edges.get(i).get(0) - 1) + 6);
                    }
                }
            }
        }
        
        ans.remove(s - 1);
        return ans;
    }
}