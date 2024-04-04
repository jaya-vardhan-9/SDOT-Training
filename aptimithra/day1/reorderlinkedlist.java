import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
import java.util.Scanner;

// basic linkedlist start
public class reorderlinkedlist {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void reorder(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node current = slow.next;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        slow.next = null;

        Node first = head;
        Node second = prev;
        while (second != null) {
            Node nextFirst = first.next;
            Node nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node head = new Node(0); 
        Node current = head;
        String[] input = s.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            int data = Integer.parseInt(input[i]);
            current.next = new Node(data);
            current = current.next;
        }

        reorder(head.next);

        current = head.next;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
