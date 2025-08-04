package Queues;

public class CircularQUseLL {
    // Circular Queue using a Single-Linked list

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class QueueC{
       static Node front;
       static Node rear;

       public static boolean isEmpty(){
               return rear == null && front == null;
       }

       public static void add(int data){
           Node newNode = new Node(data);

           if(isEmpty()){
               front = rear = newNode;
               rear.next = front;
               return;
           }

           rear.next = newNode;
           rear = newNode;
           rear.next = front;

       }

       public static int remove(){
           if(isEmpty()){
               System.out.println("Queue is empty");
               return -1;
           }

           if(front == rear){
               front = rear = null;
               return -1;
           }

           int result = front.data;
           front = front.next;
           rear.next = front;

           return result;
       }

       public static int peek(){
           if (isEmpty()) {
               System.out.println("Queue is empty");
               return -1;
           }

           return front.data;
       }

    }

    public static void main(String[] args) {
           QueueC qc = new QueueC();
           qc.add(1);
           qc.add(2);
           qc.add(3);
           qc.add(4);
           qc.add(5);
        System.out.println(qc.remove());
        System.out.println();

        while(!qc.isEmpty()){
            System.out.println(qc.peek());
            qc.remove();
        }
    }
}

