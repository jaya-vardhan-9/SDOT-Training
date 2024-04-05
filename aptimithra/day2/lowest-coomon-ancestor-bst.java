import java.util.*;
import java.lang.*;
import java.io.*;
class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int item){
        val=item;
        left=right=null;
    }
}
class Main
{
    static TreeNode root;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        String [] values=sc.nextLine().split(" ");
        int [] treeValues=new int[values.length];
        for(int i=0;i<values.length;i++){
            treeValues[i]=Integer.parseInt(values[i]);
        }
        root =buildTree(treeValues,0);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(findLCA(root,x,y).val);

    }
    static TreeNode buildTree(int[] values,int index){
        TreeNode node =null;
        if(index<values.length && values[index]!=-1){
            node =new TreeNode(values[index]);
            node.left=buildTree(values,2*index+1);
            node.right=buildTree(values,2*index+2);

        }
        return node;
    }
    static TreeNode findLCA(TreeNode root,int x,int y){
        if(root==null || root.val ==x || root.val==y){
            return root;
        }
        TreeNode leftLCA=findLCA(root.left,x,y);
        TreeNode rightLCA=findLCA(root.right,x,y);
        if(leftLCA!=null && rightLCA!=null){
            return root;
        }
        return(leftLCA!=null) ? leftLCA:rightLCA;
    }
}
