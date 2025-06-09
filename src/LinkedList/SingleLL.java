package LinkedList;

public class SingleLL {
    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

        Node head = null;

        public void addAtBeginning(int data){
            Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;

        }

        public void addAtEnd(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                return;
            }

            Node currNode = head;

            while ( currNode.next != null){
                currNode = currNode.next;
            }

            currNode.next = newNode;
        }

        public void printList(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }

            Node currNode = head;

            while ( currNode != null){
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");

        }

        public void deleteAtBeginning(){

            if(head == null){
                System.out.println("List is empty");
                return;
            }

                head = head.next;

        }

        public void deleteAtEnd(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }

            if (head.next == null) {
                head = null;
                return;
            }

           Node currNode = head;
                while(currNode.next.next != null){
                    currNode = currNode.next;
                }
                currNode.next = null;

        }

        public void addAtPosition(int data , int pos){

            if(pos < 0){
                System.out.println("Invalid index!");
                return;
            }

            if( pos == 1){
                addAtBeginning(data);
                return;
            }

           Node newNode = new Node(data);
            Node currNode = head;

            for( int i = 0; i < pos -1 ; i++){
                currNode = currNode.next;
            }

            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        public void deleteAtPosition(int pos){

            if(head == null || pos < 0){
                System.out.println("List is empty!");
                return;
            }

            if( pos == 0){
                deleteAtBeginning();
                return;
            }

            Node currNode = head;

            for(int i = 0; i < pos -1 ; i++){
                currNode = currNode.next;
            }

            if (currNode.next == null) {
                System.out.println("Index out of bounds.");
                return;
            }

            currNode.next = currNode.next.next;
        }

        public static void main(String[] args) {

            SingleLL list = new SingleLL();

            list.addAtBeginning(2);
            list.addAtEnd(3);
            list.addAtBeginning(1);
            list.printList();
            list.addAtPosition(0,1);
            list.addAtPosition(4,4);
            list.printList();
            list.deleteAtPosition(4);
            list.printList();
            list.deleteAtPosition(3);
            list.printList();



        }

}
