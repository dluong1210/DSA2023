public class ConnectedCell {
        public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int maxi = 0;
        for (int i = 0; i <matrix.size() ; i++) {
            for (int j = 0; j < matrix.get(0).size() ; j++) {
                if (matrix.get(i).get(j) == 0) continue;
                
                Queue<int[]> temp = new LinkedList<>();
                int count = 0;
                temp.add(new int[]{i, j});
                
                while (!temp.isEmpty()) {
                    int a = temp.peek()[0];
                    int b = temp.peek()[1];
                    count++;
                    temp.poll();
                    
                    for (int r = -1; r < 2; r++) {
                        for (int c = -1; c < 2; c++) {
                            if (r == 0 && c == 0) continue;
                            if (a + r >= 0 && a + r < matrix.size() && b + c >= 0 && b + c < matrix.get(0).size() && matrix.get(a + r).get(b + c) == 1) {
                                temp.add(new int[]{a + r, b + c});
                                matrix.get(a + r).set(b + c, 0);
                            }
                        }
                    }
                    matrix.get(a).set(b, 0);
                }
                maxi = Math.max(maxi, count);
            }
        }
        
        return maxi;
    }
}