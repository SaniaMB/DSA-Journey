package Queues;

public class CircularQueueUseArray {
    // Circular Queue using a Static Array

    static class Queuey{
        static int arr[];
        static int rear = -1;
        static int front = -1;
        static int size;

        Queuey(int size){
            arr = new int[size];
            Queuey.size = size;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1) % size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            if(front == -1){
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove(){
            if(rear == -1){
                System.out.println("Queue empty");
                return -1;
            }

            int element = arr[front];
            if(rear == front) rear = front = -1;
            else front = (front + 1) % size;

            return element;
        }

        public static int peek(){
            if(rear == -1){
                System.out.println("Queue empty");
                return -1;
            }

            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queuey q = new Queuey(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.add(6);
        q.remove();
        q.add(7);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
