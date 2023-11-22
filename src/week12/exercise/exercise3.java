import java.util.HashSet;

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class exercise3 {
    public static void solve(Node node) {
        if (node == null) return;

        Node temp = node;
        HashSet<Integer> check = new HashSet<>();

        while (temp != null) {
            check.add(temp.val);
            while (temp.next != null && check.contains(temp.next.val)) {
                temp.next = temp.next.next;
            }

            temp = temp.next;
        }

    }

    public static void main(String[] argv) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(1, new Node(2, new Node(4, new Node(5, new Node(4, null))))))));
        // 1 -> 2 -> 3 -> 1 -> 2 -> 4 -> 5 -> 4 -> null
        solve(root);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
