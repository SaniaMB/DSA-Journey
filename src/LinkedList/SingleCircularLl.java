package LinkedList;

public class SingleCircularLl {
    static class Node{
        int data;
        Node next;
        Node(int data){
           this.data =  data;
        }
    }

    private Node head , tail;
    private int size = 0;

    public void insert(int data, int pos){
        if(pos < 0 || pos > size) {
            System.out.println("Invalid Position!");
            return;
        }
        if(pos == 0){
            insertAtHead(data);
            return;
        }
        if(pos == size){
            insertAtEnd(data);
            return;
        }

        Node current = head;
        Node newNode = new Node(data);

        for(int i = 0; i < pos - 1; i++){
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        size++;

    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        size++;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            newNode.next = head;
        }else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void remove(int pos){
        if(pos < 0 || pos >= size){
            System.out.println("Invalid position!");
            return;
        }

        if(pos == 0){
            removeHead();
            return;
        }

        if(pos == size - 1){
            removeEnd();
            return;
        }
        Node current = head;
        for(int i = 0; i < pos-1; i++){
            current = current.next;
        }

        current.next = current.next.next;

        size--;
    }

    public void removeHead(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;  // Update tail to new head
        }
        size--;

    }

    public void removeEnd(){
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        }else {
            Node current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
        size--;
    }

    public void display(){
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;

        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while(temp != head);

        System.out.println("(head)");

    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SingleCircularLl sll = new SingleCircularLl();

        sll.insert(10, 0);      // head
        sll.insert(20, 1);      // tail
        sll.insert(15, 1);      // middle

        sll.display();

        sll.remove(0);          // remove head
        sll.remove(1);          // remove tail
        sll.remove(0);          // remove last node

        sll.insert(5, 0);
        sll.insert(6, 1);

        sll.display();

        sll.insert(10, 0);

        sll.display();



    }

}
