public class CheckBST {
    public static boolean helper(Node root, int mini, int maxi) {
        if (root == null) return true;
        if (root.data <= mini || root.data >= maxi) return false;
        
        return helper(root.left, mini, root.data) && helper(root.right, root.data, maxi);
    }

    public static boolean checkBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}