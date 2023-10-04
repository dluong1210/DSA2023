import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item> {
    Item[] array;
    int size;

    public MyStack() {
        array = (Item[]) new Object[2];
        size = 0;
    }

    private void resize(int size) {
        Item[] newArr = (Item[]) new Object[size];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public Item pop() throws Exception {
        if (size > 0) {
            size--;
            if (size <= 0.25 * array.length) {
                resize(array.length / 2);
                System.out.println(array.length);
            }
            return array[size];
        }
        throw new Exception("Stack is empty!");
    }

    public void push(Item x) {
        array[size++] = x;
        if (size == array.length) {
            resize(size * 2);
            System.out.println(array.length);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printAll() {
        System.out.print('[');
        for (Item x : this) {
            System.out.print(x + ",");
        }
        System.out.println(']');
    }

    private class StackIterator implements Iterator<Item> {
        int currentIndex = size - 1;
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex--];
        }
    }

    public Iterator<Item> iterator() {
        return new StackIterator();

}

    public static void main(String[] argv) throws Exception {
        MyStack<String> test = new MyStack<>();
//        Scanner scan = null;
//
//        try {
//            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\32Kints.txt");
//            scan = new Scanner(ip);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        while (scan.hasNext()) {
//            test.push(scan.nextInt());
//        }
//
//        while (!test.isEmpty()) {
//            test.pop();
//        }
        test.push("One");
        test.push("Two");
        test.push("Three");
        test.printAll();
        System.out.println("-push-");
        test.push("Four");
        test.printAll();
        System.out.println("-push-");
        test.push("One");
        test.printAll();
        System.out.println("-push-");
        test.push("Two");
        test.printAll();
        System.out.println("-push-");
        test.push("Three");
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
        System.out.println("-pop-");
        test.pop();
        test.printAll();
    }
}
