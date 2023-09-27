public class MyLinkedList {
    public MyNode<String> append(MyNode<String> head, String data) {
        if (head == null) {
            return new MyNode<>(data);
        }
        head.next = append(head.next, data);
        return head;
    }

    public MyNode<String> removeFirst(MyNode<String> head, String data) {
        if (head == null) return null;
        if (head.data.equals(data)) {
            return head.next;
        }
        head.next = removeFirst(head.next, data);
        return head;
    }

    public MyNode<String> removeAll(MyNode<String> head, String data) {
        if (head == null) return null;
        while (head.data.equals(data)) {
            head = head.next;
            if (head == null) return null;
        }
        head.next = removeAll(head.next, data);
        return head;
    }
    public void printList(MyNode<String> head) {
        if (head == null) return;
        System.out.println(head.data);
        printList(head.next);
    }

    public static void main(String[] argv) {
        MyNode<String> head = null;
        MyLinkedList test = new MyLinkedList();

        head = test.append(head, "Two");
        head = test.append(head, "Two");
        head = test.append(head, "One");
        head = test.append(head, "Two");
        head = test.append(head, "Three");
        head = test.append(head, "Two");

        head = test.removeAll(head, "Two");
        test.printList(head);
    }
}
