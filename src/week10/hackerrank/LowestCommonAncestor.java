public class LowestCommonAncestor {
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
          if (root.data >= Math.min(v1, v2) && root.data <= Math.max(v1, v2)) return root;
          if (root.data > v2) return lca(root.left, v1, v2);
          if (root.data < v1) return lca(root.right, v1, v2);
          return null;
    }
}