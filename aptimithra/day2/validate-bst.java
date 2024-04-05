import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("-1")) return null;
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("-1")) {
                treeNodes[i] = new TreeNode(Integer.parseInt(nodes[i]));
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if (treeNodes[i] != null) {
                if (2 * i + 1 < nodes.length && !nodes[2 * i + 1].equals("-1")) {
                    treeNodes[i].left = treeNodes[2 * i + 1];
                }
                if (2 * i + 2 < nodes.length && !nodes[2 * i + 2].equals("-1")) {
                    treeNodes[i].right = treeNodes[2 * i + 2];
                }
            }
        }
        return treeNodes[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // 
        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine().trim();
            String[] nodesStr = input.split(" ");
            TreeNode root = buildTree(nodesStr);
            System.out.println(isValidBST(root) ? "true" : "false");
        }
    }
}
