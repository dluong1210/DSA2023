public class MergeList {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode ans = new SinglyLinkedListNode(0), temp = ans;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                ans.data = head1.data;
                head1 = head1.next;
            } else {
                ans.data = head2.data;
                head2 = head2.next;
            }
            ans.next = new SinglyLinkedListNode(0);
            ans = ans.next;
        }
        if (head1 != null) {
            ans.next = head1.next;
            ans.data = head1.data;
        }
        else if (head2 != null) {
            ans.next = head2.next;
            ans.data = head2.data;
        }
        else ans = null;
        return temp;
    }
}