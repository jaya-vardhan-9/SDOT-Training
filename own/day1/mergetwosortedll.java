import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class mergetwosortedll {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        ListNode l1 = createList(scanner, n1);

        int n2 = scanner.nextInt();
        
        ListNode l2 = createList(scanner, n2);

        mergetwosortedll merger = new mergetwosortedll();
        ListNode mergedList = merger.mergeTwoLists(l1, l2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }

        scanner.close();
    }

    private static ListNode createList(Scanner scanner, int n) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}
