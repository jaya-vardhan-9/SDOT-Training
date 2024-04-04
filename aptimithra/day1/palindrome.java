import java.util.*;

 class palindrome {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int size;

    public Node head = null;
    public Node tail = null;

    public void addNode(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next=newnode;
            tail=newnode;
        }
        size++;
    }

    public void isPalindrome(){
        Node current = head;
        boolean flag = true;
        int mid = (size%2==0)?(size/2):((size+1)/2);
        for(int i=1;i<mid;i++){
            current = current.next;
        }
        Node revHead = reverseList(current.next);
        while(head!=null && revHead != null){
            if(head.data!=revHead.data){
                flag = false;
                break;
            }
            head=head.next;
            revHead=revHead.next;
        }
        if(flag){
            System.out.println("True");
        }
    }

    
}
