import java.util.*;
import java.lang.*;
import java.io.*;
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
public class Main {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode right = root.right;
        if (root.left != null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
        }
        flatten(right);
        root.right = right;
    }
    public void printLinkedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        String treeStr = scanner.nextLine();
        TreeNode root = constructTree(treeStr);
        Main solution = new Main();
        solution.flatten(root);
        solution.printLinkedList(root);
    }
    private static TreeNode constructTree(String treeStr) {
        if (treeStr.equals("N")) return null;
        String[] nodes = treeStr.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode curr = queue.poll();
            if (!nodes[index].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curr.left);
            }
            index++;
            if (!nodes[index].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curr.right);
            }
            index ++;
        }
        return root;
    }
}
