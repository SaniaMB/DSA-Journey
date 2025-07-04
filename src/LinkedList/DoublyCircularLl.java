package LinkedList;

public class DoublyCircularLl {
    static class Node{
        int data;
        Node prev, next;

        Node(int data){
            this.data = data;
        }
    }

    private Node head, tail;
    private int size = 0;

    public void insert(int data, int pos){
        if(pos < 0 || pos > size){
            System.out.println("Invalid Position!");
            return;
        }
        if(pos == 0){
            insertAtHead(data);
            return;
        }
        if(pos == size){
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for(int i = 0; i < pos -1; i++){
            current = current.next;
        }

        Node nextNode = current.next;

        current.next = newNode;

        newNode.prev = current;
        newNode.next = nextNode;

        nextNode.prev = newNode;

        size++;
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            head.next = head;
            head.prev = head;

            size++;
            return;
        }

        newNode.next = head;
        newNode.prev = tail;

        head.prev = newNode;
        head = newNode;

        tail.next = head;

        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            head.next = head;
            head.prev = head;

            size++;
            return;
        }

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        tail = newNode;

        head.prev = tail;

        size++;
    }

    public void remove(int pos){
        if(pos < 0 || pos > size -1 ){
            System.out.println("List is Empty!");
            return;
        }

        if(pos == 0){
            removeAtHead();
            return;
        }

        if(pos == size -1){
            removeAtTail();
            return;
        }

        Node current = head;

        for(int i = 0; i < pos; i++){
            current = current.next;
        }

        Node nextNode = current.next;
        Node prevNode = current.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }

    public void removeAtHead(){
        if(head == null){
            System.out.println("List is Empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node prevNode = head.prev;
        Node nextNode = head.next;

        head = head.next;
        head.prev = prevNode;
        prevNode.next = head;

        size--;
    }

    public void removeAtTail(){
        if(tail == null){
            System.out.println("List is Empty!");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }

        Node prevNode = tail.prev;
        Node nextNode = head;

        tail = tail.prev;
        tail.next = nextNode;
        head.prev = tail;

        size--;
    }

    public void displayForward(){
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void displayBackward(){
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        DoublyCircularLl list = new DoublyCircularLl();

        list.insert(30, 0);
        list.insert(20, 0);
        list.insert(10, 0);

        list.insert(40, 3);
        list.insert(50, 4);

        list.insert(25, 2);

        System.out.print("Forward: ");
        list.displayForward();

        System.out.print("Backward: ");
        list.displayBackward();

        list.remove(0);
        list.remove(list.getSize() - 1);
        list.remove(1);

        list.displayForward();
    }

}
