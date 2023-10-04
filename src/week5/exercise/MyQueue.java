import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<Item> implements Iterable<Item> {
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

    public void add(Item x) {
        array[rankToIndex(size)] = x;
        size++;
        if (size == array.length) resize(2 * array.length);
    }

    public Item top() {
        return array[begin];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printAll() {
        System.out.print("[");
        for (Item x : this) {
            System.out.print(x + " ");
        }
        System.out.println("] array length: " + array.length);
    }

    private class QueueIterator implements Iterator<Item> {
        private int currentRank = 0;

        public boolean hasNext() {
            return currentRank < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[rankToIndex(currentRank++)];
        }
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    public static void main(String[] argv) throws Exception {
        MyQueue<String> test = new MyQueue<>();
        test.add("One");
        test.add("Two");
        test.add("Three");
        test.printAll();
        System.out.println("-push-");
        test.add("Four");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.add("One");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.add("Two");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-push-");
        test.add("Three");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();

    }
}
