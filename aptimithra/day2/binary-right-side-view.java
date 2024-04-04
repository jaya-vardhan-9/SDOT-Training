import java.util.*; 

import java.lang.*; 

import java.io.*; 

 

class Main { 

    static class Node { 

        int data; 

        Node left; 

        Node right; 

 

        public Node(int data) { 

            this.data = data; 

            this.right = null; 

            this.left = null; 

        } 

    } 

 

    public static List<Integer> rightView(Node root) { 

        List<Integer> rightView = new ArrayList<>(); 

        if (root == null) { 

            return rightView; 

        } 

        Queue<Node> q = new LinkedList<>(); 

        q.add(root); 

        while (!q.isEmpty()) { 

            int size = q.size(); 

            for (int i = 0; i < size; i++) { 

                Node node = q.poll(); 

                if (i == size - 1) { 

                    rightView.add(node.data); 

                } 

                if (node.left != null) { 

                    q.add(node.left); 

                } 

                if (node.right != null) { 

                    q.add(node.right); 

                } 

            } 

        } 

        return rightView; 

    } 

 

    public static Node buildTree(String str) { 

        if (str.length() == 0 || str.charAt(0) == 'N') { 

            return null; 

        } 

        String[] ip = str.split("\\s+"); 

        Node root = new Node(Integer.parseInt(ip[0])); 

        Queue<Node> q = new LinkedList<>(); 

        q.add(root); 

        int i = 1; 

        while (!q.isEmpty() && i < ip.length) { 

            Node currNode = q.poll(); 

            String currVal = ip[i]; 

            if (!currVal.equals("N")) { 

                currNode.left = new Node(Integer.parseInt(currVal)); 

                q.add(currNode.left); 

            } 

            i++; 

            if (i >= ip.length) { 

                break; 

            } 

            currVal = ip[i]; 

            if (!currVal.equals("N")) { 

                currNode.right = new Node(Integer.parseInt(currVal)); 

                q.add(currNode.right); 

            } 

            i++; 

        } 

        return root; 

    } 

 

    public static void main(String[] args) throws java.lang.Exception { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) { 

            String s = br.readLine(); 

            Node root = buildTree(s); 

            List<Integer> rightViewList = rightView(root); 

            for (int x : rightViewList) { 

                System.out.print(x + " "); 

            } 

            System.out.println(); 

        } 

    } 

} 