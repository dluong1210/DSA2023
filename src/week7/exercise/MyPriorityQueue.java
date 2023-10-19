import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import edu.princeton.cs.algs4.*;

public class MyPriorityQueue {
    int[] temp;
    int size;

    public MyPriorityQueue() {
        temp = new int[2];
        size = 0;
    }

    public MyPriorityQueue(List<Integer> arr) {
        size = 0;
        temp = new int[2 * arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            this.push(arr.get(i));
        }
    }

    private void resize(int length) {
        int[] newArr = new int[length];
        for (int i = 0; i < size; i++) {
            newArr[i] = temp[i];
        }
        temp = newArr;
        System.out.println(size);
    }

    private int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private int child(int i) {
        return (i + 1) * 2 - 1;
    }

    public int top() {
        return temp[0];
    }

    public void push(int a) {
        temp[size++] = a;
        if (size == temp.length - 1) resize(size * 2);
        int i = size - 1;
        while (i > 0 && temp[i] > temp[parent(i)]) {
            int rmb = temp[i];
            temp[i] = temp[parent(i)];
            temp[parent(i)] = rmb;
            i = parent(i);
        }
    }

    public int pop() {
        int ans = this.top();
        int i = 0;
        temp[0] = temp[--size];
        if (size <= 0.25 * temp.length) resize(temp.length / 2);

        while (child(i) < size) {
            if (temp[i] > temp[child(i)] && (child(i) + 1 == size - 1 || temp[i] > temp[child(i) + 1])) break;
            if (child(i) + 1 == size - 1 || temp[child(i)] > temp[child(i)+1]) {
                if (temp[child(i)] > temp[i]) {
                    int rmb = temp[i];
                    temp[i] = temp[child(i)];
                    temp[child(i)] = rmb;
                    i = child(i);
                }
            } else {
                int rmb = temp[i];
                temp[i] = temp[child(i) + 1];
                temp[child(i) + 1] = rmb;
                i = child(i) + 1;
            }
        }
        return ans;
    }

    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<>();
        try {
            File ip = new File("C:\\Users\\7420\\Desktop\\Code\\Java\\algs4-data\\32Kints.txt");
            Scanner scan = new Scanner(ip);
            while (scan.hasNext()) {
                arr.add(scan.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Stopwatch watch = new Stopwatch();

        MyPriorityQueue test = new MyPriorityQueue(arr);
        while (!test.empty()){
            test.pop();
        }
        System.out.println("Time run:" + (double)watch.elapsedTime() + " s");
    }
}
