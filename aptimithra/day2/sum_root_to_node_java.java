import java.util.Scanner; 

 

class TreeNode { 

    int val; 

    TreeNode left, right; 

 

    public TreeNode(int val) { 

        this.val = val; 

    } 

} 

 

public class sum_root_to_node_java { 

 

    public int sumNumbers(TreeNode root) { 

        return sumNumbersHelper(root, 0); 

    } 

 

    private int sumNumbersHelper(TreeNode node, int currentSum) { 

        if (node == null) { 

            return 0; 

        } 

 

        currentSum = currentSum * 10 + node.val; 

 

        if (node.left == null && node.right == null) { 

            return currentSum; 

        } 

 

        int leftSum = sumNumbersHelper(node.left, currentSum); 

        int rightSum = sumNumbersHelper(node.right, currentSum); 

 

        return leftSum + rightSum; 

    } 

 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

 

        String input = scanner.nextLine(); 

 

        TreeNode root = buildTree(input.split(""), 0); 

 

        sum_root_to_node_java  sumRootToLeaf = new sum_root_to_node_java (); 

        int result = sumRootToLeaf.sumNumbers(root); 

 

        System.out.println(result); 

    } 

 

    private static TreeNode buildTree(String[] values, int index) { 

        if (index >= values.length || values[index].equals("N")) { 

            return null; 

        } 

 

        TreeNode node = new TreeNode(Integer.parseInt(values[index])); 

        node.left = buildTree(values, 2 * index + 1); 

        node.right = buildTree(values, 2 * index + 2); 

 

        return node; 

    } 

} 