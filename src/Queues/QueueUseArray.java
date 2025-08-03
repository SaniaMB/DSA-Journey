package Queues;

public class QueueUseArray {
    static class Queuey{
        static int arr[];
        static int rear = -1;
        static int size;

        Queuey(int size){
            arr = new int[size];
            Queuey.size = size;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        public static int remove(){
            if(rear == -1){
                System.out.println("Queue empty");
                return -1;
            }

            int front = arr[0];
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];
            }

            rear--;
            return front;
        }

        public static int peek(){
            if(rear == -1){
                System.out.println("Queue empty");
                return -1;
            }

            return arr[0];
        }

    }

    public static void main(String[] args) {
        Queuey q = new Queuey(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
