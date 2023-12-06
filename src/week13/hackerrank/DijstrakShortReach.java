public class DijstrakShortReach {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
    // Write your code here
        List<Integer> instance = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Map<Integer, List<int[]>> temp = new HashMap<>();
        PriorityQueue<int[]> check = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        for (int i = 0; i < n; i++) {
            instance.add(Integer.MAX_VALUE);
            visited[i] = false;
        }
        for (List<Integer> e : edges) {
            temp.putIfAbsent(e.get(0), new ArrayList<>());
            temp.putIfAbsent(e.get(1), new ArrayList<>());
            
            temp.get(e.get(0)).add(new int[] {e.get(1), e.get(2)});
            temp.get(e.get(1)).add(new int[] {e.get(0), e.get(2)});
        }
        
        instance.set(s - 1, 0);
        check.add(new int[]{s, 0});
        
        while (!check.isEmpty()) {
            int current = check.poll()[0];
            if (visited[current - 1]) continue;
            visited[current - 1] = true;
            
            for (int[] e : temp.get(current)) {
                if (visited[e[0] - 1]) continue;
                if (instance.get(e[0] - 1) > instance.get(current - 1) + e[1]) {
                    instance.set(e[0] - 1, instance.get(current - 1) + e[1]);
                    check.add(new int[]{e[0], instance.get(e[0] - 1)});
                }
            }
        }
        
        instance.remove(s - 1);
        for (int i = 0; i < instance.size(); i++) {
            if (instance.get(i) == Integer.MAX_VALUE) instance.set(i, -1);
        }
        return instance;
    }

}