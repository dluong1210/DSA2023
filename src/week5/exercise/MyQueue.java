public class MyQueue<Item> {
    Item[] array;
    int size;
    int begin;

    public MyQueue() {
        array = (Item[]) new Object[2];
        size = 0;
        begin = 0;
    }

    private int rankToIndex(int rank) {
        return (rank + begin) % array.length;
    }

    private void resize(int size) {
        Item[] newArr = (Item[]) new Object[size];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = array[rankToIndex(i)];
        }
        begin = 0;
        array = newArr;
    }

    public Item pop() throws Exception {
        if (size > 0) {
            Item front = array[begin++];
            if (begin == array.length) begin = 0;
            size--;
            if (size <= array.length / 4) resize(array.length / 2);
            return front;
        }
        throw new Exception("Queue is empty");
    }

    public void push(Item x) {
        array[rankToIndex(size)] = x;
        size++;
        if (size == array.length) resize(2 * array.length);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printAll() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(rankToIndex(i) + " ");
        }
        System.out.println("] array length: " + array.length);
    }

    public static void main(String[] argv) throws Exception {
        MyQueue<String> test = new MyQueue<>();
        test.push("One");
        test.push("Two");
        test.push("Three");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.push("Four");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.push("One");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.push("Two");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.push("Three");
        test.printAll();

    }
}
