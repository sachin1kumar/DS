package queue;

import java.util.Stack;

public class QueueUsingStack {

    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        System.out.println(dequeue() + " " + dequeue() + " " + dequeue());
    }

    private static void enqueue(int element) {
        //O(1)
        stack1.push(element);
    }

    private static int dequeue() {
        if (stack1.empty() && stack2.empty()) {
            System.out.println("Queue is empty");
        }
        //Move elements from stack1 to stack2 in O(n)
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        int top = stack2.peek();
        stack2.pop();
        return top;
    }
}
