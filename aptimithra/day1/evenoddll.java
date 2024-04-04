import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
class Solution{
    public ListNode oddEvenList(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode evenHead = null,evenTail = null;
        ListNode oddHead = null,oddTail = null;

        ListNode current = head;

        while(current!= null){
            if(current.val%2 == 0){
                if(evenHead == null){
                    evenHead = current;
                    evenTail = current;
                }else{
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = current;
                    oddTail = current;
                }else{
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current=current.next;
        }
        if(evenTail!=null){
            evenTail.next = oddHead;
        }else{
            evenHead = oddHead;
        }

        if(oddTail!=null){
            oddTail.next = null;
        }
        return evenHead;
    }
}
public class evenoddll{
    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ListNode head=null;
        ListNode current=null;

        for (String s: input){
            int val=Integer.parseInt(s);
            if(head == null){
                head=new ListNode(val);
                current=head;
            }else{
                current.next=new ListNode(val);
                current = current.next;
            }
        }
        Solution sol = new Solution();
        ListNode res = sol.oddEvenList(head);
        printList(res);
    }
}

