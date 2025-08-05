package Queues;

public class QueueUse2Ll {
    // Implementing Queue Using two Stacks made using a Single-Linked list

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static class StackLL {
        Node top;

        public boolean isEmpty() {
            return top == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack underflow");
            int value = top.data;
            top = top.next;
            return value;
        }

        public int peek() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return top.data;
        }
    }

    // Queue using 2 stacks with O(n) enqueue
    static class Queue {
        StackLL s1 = new StackLL();
        StackLL s2 = new StackLL();

        public void enqueue(int data) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int dequeue() {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return s1.pop();
        }

        public int peek() {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return s1.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue()); // 1
        q.enqueue(4);
        System.out.println(q.peek());    // 2
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        System.out.println(q.dequeue()); // 4
    }
}

