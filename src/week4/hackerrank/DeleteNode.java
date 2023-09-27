public class DeleteNode {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    // Write your code here
        if (position == 0) return llist.next;
        SinglyLinkedListNode p = new SinglyLinkedListNode(0);
        p = llist;
        while (position != 1) {
            p = p.next;
            position--;
        }
        p.next = p.next.next;
        return llist;
    }
}