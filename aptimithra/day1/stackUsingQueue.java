import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
 
    // Function to push element onto the stack
    void push(int x) {
        // Add the element to queue1
        queue1.offer(x);
    }
 
    // Function to pop element from the stack
    int pop() {
        if (queue1.isEmpty())
            return -1; // Stack is empty
 
        // Move all elements from queue1 to queue2 except the last one
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
 
        // Pop the last element from queue1 (which is the top element of the stack)
        int poppedElement = queue1.poll();
 
        // Swap the queues so that queue2 becomes queue1
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
 
        return poppedElement;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        StackUsingQueues stack = new StackUsingQueues();
 
        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int x = scanner.nextInt();
                stack.push(x);
            } else if (queryType == 2) {
                int poppedElement = stack.pop();
                System.out.println(poppedElement);
            }
        }
    }
}
