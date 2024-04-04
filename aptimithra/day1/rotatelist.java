class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

class rotatelist{
    public static void main(String[] args) {
        if(head == null || head.next ==null || k==0){
            return head;

            int length =1;
            ListNode tail = head;
            while(tail.next != null){
                tail=tail.next;
            }
            k=k%length;
            if(k==0){
                return head;
            }

            ListNode newTail = head;
            for(int i=0;i<length;i++){
                newTail=newTail.next;
            }

            ListNode newHead = newTail.next;
            newTail.next=null;
            tail.next=head;

            return newHead;
        }
    }
}

public class rotatelist {
    
}
