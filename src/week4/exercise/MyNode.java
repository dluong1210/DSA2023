public class MyNode<Item> {
    Item data;
    MyNode next;

    public MyNode() {}
    public MyNode(Item data) {
        this.data = data;
    }
    public MyNode(MyNode<Item> other) {
        data = other.data;
        next = other.next;
    }
}
