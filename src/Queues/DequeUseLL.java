package Queues;

public class DequeUseLL {
    //  Deque using a Doubly Linked list

   static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    static class DequeLL{
       static Node head;
       static Node tail;

       public static boolean isEmpty(){
           return head == null && tail == null;
       }

       public static void add(int data){
           Node newNode = new Node(data);

           if(isEmpty()){
               head = tail = newNode;
               newNode.prev = head;
           }

           tail.next = newNode;
           newNode.prev = tail;
           tail = newNode;
       }

        public static void addAtFront(int data){
            Node newNode = new Node(data);

            if(isEmpty()){
                head = tail = newNode;
                newNode.prev = head;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

       public static int remove(){
           if(isEmpty()){
               System.out.println("Queue is Empty");
               return -1;
           }

           int result = head.data;

           if(head == tail){
               head = tail = null;
           }else {
               head = head.next;
               head.prev = null;
           }

           return result;
       }

        public static int removeAtRear(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = tail.data;

            if(head == tail){
                head = tail = null;
            }else {
                tail = tail.prev;
                tail.next = null;
            }

            return result;

        }


       public static int peek(){
           if(isEmpty()){
               System.out.println("Queue is empty");
               return -1;
           }

           return head.data;
       }
    }

    public static void main(String[] args) {
        DequeLL deq = new DequeLL();

        deq.add(1);
        deq.add(2);
        deq.add(3);
        deq.add(4);
        deq.add(5);

        deq.addAtFront(6);
        deq.addAtFront(6);
        deq.addAtFront(6);
        deq.addAtFront(7);

        System.out.println(deq.removeAtRear());
        System.out.println();

        while(!deq.isEmpty()){
            System.out.println(deq.peek());
            deq.remove();
        }
    }
}
