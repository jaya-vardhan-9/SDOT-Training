import java.util.*; 

 

class TreeNode { 

    int val; 

    TreeNode left, right; 

 

    public TreeNode(int val) { 

        this.val = val; 

        this.left = this.right = null; 

    } 

} 

 

public class binaryTreeZigZag { 

 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

 

        String input = scanner.nextLine(); 

 

        TreeNode root = buildTree(input); 

 

        zigZagLevelOrder(root); 

    } 

 

    public static TreeNode buildTree(String input) { 

        String[] nodes = input.split("\\s+"); 

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

 

    public static void zigZagLevelOrder(TreeNode root) { 

        if (root == null) { 

            return; 

        } 

 

        Stack<TreeNode> currentLevel = new Stack<>(); 

        Stack<TreeNode> nextLevel = new Stack<>(); 

        boolean leftToRight = true; 

 

        currentLevel.push(root); 

 

        while (!currentLevel.isEmpty()) { 

            TreeNode node = currentLevel.pop(); 

            System.out.print(node.val + " "); 

 

            if (leftToRight) { 

                if (node.left != null) nextLevel.push(node.left); 

                if (node.right != null) nextLevel.push(node.right); 

            } else { 

                if (node.right != null) nextLevel.push(node.right); 

                if (node.left != null) nextLevel.push(node.left); 

            } 

 

            if (currentLevel.isEmpty()) { 

                leftToRight = !leftToRight; 

                Stack<TreeNode> temp = currentLevel; 

                currentLevel = nextLevel; 

                nextLevel = temp; 

            } 

        } 

    } 

} 