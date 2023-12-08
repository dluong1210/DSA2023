public class SelfBalancingTree {

    public static int getBf(Node root) {
        int htLeft = root.left == null ? -1 : root.left.ht;
        int htRight = root.right == null ? -1 : root.right.ht;
        
        return htLeft - htRight;
    }
    public static int getHt(Node root) {
        if (root.left == null && root.right == null) return 0;
        if (root.left == null) return 1 + root.right.ht;
        if (root.right == null) return 1 + root.left.ht;
        
        return 1 + Math.max(root.left.ht, root.right.ht);
    }
    public static Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.ht--;
        temp.ht++;
        return temp;
    }
    public static Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.ht--;
        temp.ht++;
        return temp;
    }

	public static Node insert(Node root,int val)
    {
        if (root == null) {
            Node temp = newNode(val);
            temp.ht = 0;
            return temp;
        }
        if (root.val == val) return root;
        if (root.val > val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        if (Math.abs(getBf(root)) > 1) {
            if (getBf(root) < 0) {
                if (getBf(root.right) > 0) {
                    root.right = rotateRight(root.right);
                }
                root = rotateLeft(root);
            } else {
                if (getBf(root.left) < 0) {
                    root.left = rotateLeft(root.left);
                }
                root = rotateRight(root);
            }
        }
        
        root.ht = getHt(root);

        return root;
    }
}