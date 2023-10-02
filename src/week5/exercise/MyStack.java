import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyStack<Item> {
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

    public static void main(String[] argv) throws Exception {
        MyStack<Integer> test = new MyStack<>();
        Scanner scan = null;

        try {
            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\32Kints.txt");
            scan = new Scanner(ip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNext()) {
            test.push(scan.nextInt());
        }

        while (!test.isEmpty()) {
            test.pop();
        }
    }
}
