public class InsertNodeTail {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode p = new SinglyLinkedListNode(data);
        if(head == null) return p;
        p = head;
        while (p.next != null) p = p.next;
        p.next = new SinglyLinkedListNode(data);
        return head;
    }
}