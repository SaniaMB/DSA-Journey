package LinkedList;

public class DoubleLl {
   static class Node{
        int data;
        Node next, prev;

        Node(int data){
            this.data = data;
        }
    }

    private Node head, tail;
    private int size = 0;

    public void insert(int data, int pos){
        if(pos < 0 || pos > size){
            System.out.println("Invalid insert position!");
            return;
        }

        if(pos == 0) {
            insertAtHead(data);
            return;
        }
        else if(pos == size) {
            insertAtTail(data);
            return;
        }
        else{
        Node newNode = new Node(data);
        Node current = head;

        for(int i = 0; i < pos -1; i++){
                current = current.next;
        }

        Node nextNode = current.next;

        newNode.next = nextNode;
        newNode.prev = current;

        current.next = newNode;
        nextNode.prev = newNode;

        }
        size++;
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
        }else{
             tail.next = newNode;
             newNode.prev = tail;
             tail = newNode;
        }
        size++;
    }

    public void remove(int pos){
        if (pos< 0 || pos >= size) {
            System.out.println("Invalid remove position");
            return;
        }
        if(pos == 0) {
            removeAtHead();
            return;
        }
        if(pos == size-1) {
            removeAtTail();
            return;
        }
        else {
            Node current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }

            Node nextNode = current.next;
            Node prevNode = current.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
    }

    public void removeAtHead(){
        if(head == null){
            System.out.println("Already empty list!");
            return;
        }
        if(size == 1) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeAtTail(){
        if(tail == null){
            System.out.println("Already empty list!");
            return;
        }
        if(size == 1) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void displayForward(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        Node current = tail;
        while (current != null){
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        DoubleLl dll = new DoubleLl();

        dll.insert(10, 0); // head
        dll.insert(20, 1); // tail
        dll.insert(5, 0);  // new head
        dll.insert(15, 2); // middle
        dll.insert(25, dll.getSize()); // end

        dll.displayForward();   // 5 <-> 10 <-> 15 <-> 20 <-> 25
        dll.displayBackward();  // 25 <-> 20 <-> 15 <-> 10 <-> 5

        dll.remove(0); // remove head
        dll.remove(2); // remove middle
        dll.remove(dll.getSize() - 1); // remove tail

        dll.displayForward();
    }



}
