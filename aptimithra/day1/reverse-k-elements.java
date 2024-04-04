import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k); 
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }

        return head;
    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String s : input) {
            int val = Integer.parseInt(s);
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        ListNode head = dummy.next;
        int k = scanner.nextInt();
        scanner.close();
        head = reverseKGroup(head, k);
        printList(head);
    }
} 
