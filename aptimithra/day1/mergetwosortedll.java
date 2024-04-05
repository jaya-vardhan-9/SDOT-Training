import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    }
}
public class mergetwosortedll {
    public static ListNode mergeLists(ListNode l1, ListNode l2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (l1 != null) {
        minHeap.offer(l1.val);
        l1 = l1.next;
        }
            while (l2 != null) {
            minHeap.offer(l2.val);
            l2 = l2.next;
            }
                ListNode dummy = new ListNode(-1);
                ListNode current = dummy;
                while (!minHeap.isEmpty()) {
                current.next = new ListNode(minHeap.poll());
                current = current.next;
                }
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        ListNode l1 = new ListNode(scanner.nextInt());
        ListNode current = l1;
            for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
            }
                int m = scanner.nextInt(); 
                ListNode l2 = new ListNode(scanner.nextInt());
                current = l2;
                    for (int i = 1; i < m; i++) {
                    current.next = new ListNode(scanner.nextInt());
                    current = current.next;
                    }

    ListNode mergedList = mergeLists(l1, l2);
    printList(mergedList);
    scanner.close();
    }
}
