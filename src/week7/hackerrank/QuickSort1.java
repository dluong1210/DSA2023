public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        m.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(0)) r.add(arr.get(i));
            else if (arr.get(i) < arr.get(0)) l.add(arr.get(i));
            else m.add(arr.get(i));
        }
        l.addAll(m);
        l.addAll(r);
        return l;
    }
}