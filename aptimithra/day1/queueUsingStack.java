import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Function to enqueue an element into the queue.
    void enqueue(int data) {
        stack1.push(data);
    }

    // Function to dequeue an element from the queue.
    int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return -1; // Queue is empty
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        Scanner sc = new Scanner(System.in);

        int queries = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < queries; i++) {
            String query = sc.nextLine();
            String[] parts = query.split(" ");

            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int data = Integer.parseInt(parts[1]);
                queue.enqueue(data);
            } else if (type == 2) {
                System.out.println(queue.dequeue());
            }
        }
    }
}
