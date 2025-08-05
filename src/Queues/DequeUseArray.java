package Queues;

public class DequeUseArray {
    // Deque implementation using array (circular)

    static class DequeA {
        static int[] arr;
        static int front = -1;
        static int rear = -1;
        static int size;

        DequeA(int size) {
            arr = new int[size];
            DequeA.size = size;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void addAtRear(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if (front == -1) {
                front = rear = 0;
                arr[rear] = data;
                return;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public static int removeAtFront() {
            if (rear == -1) {
                System.out.println("Queue empty");
                return -1;
            }

            int element = arr[front];
            if (rear == front) rear = front = -1;
            else front = (front + 1) % size;

            return element;
        }

        public static void addAtFront(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if (front == -1) {
                front = rear = 0;
                arr[front] = data;
                return;
            }

            front = (front - 1 + size) % size;
            arr[front] = data;
        }

        public static int removeAtRear() {
            if (rear == -1) {
                System.out.println("Queue empty");
                return -1;
            }

            int element = arr[rear];
            if (rear == front) rear = front = -1;
            else rear = (rear - 1 + size) % size;

            return element;
        }

        public static int peek() {
            if (rear == -1) {
                System.out.println("Queue empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        DequeA da = new DequeA(6);

        da.addAtRear(1);
        da.addAtRear(2);
        da.addAtRear(3);
        da.addAtRear(4);

        System.out.println(da.removeAtFront());
        System.out.println();

        da.addAtFront(5);
        System.out.println(da.peek());
        System.out.println();

        System.out.println(da.removeAtRear());
        System.out.println();

        while(!da.isEmpty()){
            System.out.println(da.peek());
            da.removeAtFront();
        }
    }
}
