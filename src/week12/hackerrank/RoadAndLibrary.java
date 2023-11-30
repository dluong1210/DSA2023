public class RoadAndLibrary {
        private static int parent(int i, int[] arr) {
        while(arr[arr[i]] != i) {
            i = arr[i];
        }
        
        return i;
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    // Write your code here
        int count = n;
        int[] city = new int[n];
        for (int i = 0; i < n; i++) {
            city[i] = i;
        }
        
        for (int i = 0; i < cities.size(); i++) {
            if (parent(cities.get(i).get(0) - 1, city) != parent(cities.get(i).get(1) - 1, city)) {
                count--;
                city[parent(cities.get(i).get(0) - 1, city)] = parent(cities.get(i).get(1) - 1, city);
            }
        }
        long a = (long) count * c_lib + (long) (n - count) * c_road;
        long b = (long) n * c_lib;
        
        if (a < b) return a;
        return b;
    }
}