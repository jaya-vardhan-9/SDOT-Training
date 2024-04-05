import java.util.Scanner; 

 

class TreeNode { 

    int val; 

    TreeNode left, right; 

 

    public TreeNode(int val) { 

        this.val = val; 

        this.left = this.right = null; 

    } 

} 

 

public class Main { 

 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

 

        String input = scanner.nextLine(); 

 

        TreeNode root = buildTree(input.split("\\s+")); 

 

        int diameter = findDiameter(root); 

        System.out.println( diameter); 

    } 

 

    public static TreeNode buildTree(String[] nodes) { 

        return buildTreeHelper(nodes, 0); 

    } 

 

    private static TreeNode buildTreeHelper(String[] nodes, int index) { 

        if (index >= nodes.length || nodes[index].equals("N")) { 

            return null; 

        } 

 

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index])); 

        node.left = buildTreeHelper(nodes, 2 * index + 1); 

        node.right = buildTreeHelper(nodes, 2 * index + 2); 

 

        return node; 

    } 

 

    public static int findDiameter(TreeNode root) { 

        if (root == null) { 

            return 0; 

        } 

 

        int leftHeight = height(root.left); 

        int rightHeight = height(root.right); 

 

        int leftDiameter = findDiameter(root.left); 

        int rightDiameter = findDiameter(root.right); 

 

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter)); 

    } 

 

    public static int height(TreeNode node) { 

        if (node == null) { 

            return 0; 

        } 

 

        int leftHeight = height(node.left); 

        int rightHeight = height(node.right); 

 

        return 1 + Math.max(leftHeight, rightHeight); 

    } 

} 