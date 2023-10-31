import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    public static void traversal(Node root, List<List<Integer>> temp, int level) {
        if (root == null) return;
        if (level == temp.size()) temp.add(new ArrayList<Integer>());
        temp.get(level).add(root.data);
        
        traversal(root.left, temp, level + 1);
        traversal(root.right, temp, level + 1);
    }
    
	public static void levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(root, ans, 0);
        for (List<Integer> temp : ans) {
            for (int a : temp) {
                System.out.print(a + " ");
            }
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}