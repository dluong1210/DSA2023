public class IntroTutorial {
    public static int introTutorial(int V, List<Integer> arr) {
    // Write your code here
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > V) r = --mid;
            else l = ++mid;
        }
        return --l;
    }
}