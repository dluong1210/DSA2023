public class ReverseList {
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Write your code here
        if (llist == null || llist.next == null) return llist;
        SinglyLinkedListNode head = new SinglyLinkedListNode(llist.data);
        while (llist != null && llist.next != null) {
            SinglyLinkedListNode temp = new SinglyLinkedListNode(llist.next.data);
            temp.next = head;
            head = temp;
            llist.next = llist.next.next;
        }
        return head;
    }
}