public class PrintReverse {
    public static void reversePrint(SinglyLinkedListNode llist) {
    // Write your code here
        if (llist.next != null) reversePrint(llist.next);
        System.out.println(llist.data);
    }
}