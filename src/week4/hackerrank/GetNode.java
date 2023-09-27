public class GetNode {
    public static int getNode(SinglyLinkedListNode llist, Integer pos) {
    // Write your code here
        Stack<Integer> rmb = new Stack<>();
        while (llist != null) {
            rmb.add(llist.data);
            llist = llist.next;
        }
        for (int i = 0; i < pos; i++) {
            rmb.pop();
        }
        return rmb.peek();
    }

}