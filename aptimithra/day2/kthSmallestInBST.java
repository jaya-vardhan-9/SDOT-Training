class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
 
    TreeNode(int val) {
        this.val = val;
    }
}
 
class KthSmallestInBST {
 
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        return kthSmallestHelper(root, k, count);
    }
 
    private int kthSmallestHelper(TreeNode node, int k, int count) {
        if (node == null) {
            return -1;
        }
 
        int leftCount = kthSmallestHelper(node.left, k, count);
        if (leftCount != -1) {
            return leftCount;
        }
 
        count++;
        if (count == k) {
            return node.val;
        }
 
        return kthSmallestHelper(node.right, k, count);
    }
 
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
 
        KthSmallestInBST solution = new KthSmallestInBST();
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println(result);
    }
}