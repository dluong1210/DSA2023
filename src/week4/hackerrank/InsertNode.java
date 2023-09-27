public class insertNode {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    // Write your code here
        SinglyLinkedListNode p = new SinglyLinkedListNode(data);
        if (position == 0) {
            p.next = llist;
            return p;
        }
        p = llist;
        while (position != 1) {
            p = p.next;
            position--;
        }
        SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
        temp.next = p.next;
        p.next = temp;
        return llist;
    }

}