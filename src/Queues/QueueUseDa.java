package Queues;

import java.util.ArrayList;

public class QueueUseDa {
    //  Queue using dynamic list (ArrayList in Java)

    static class Queue{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void add(int data){
            list.add(data);
        }

        public static int remove(){
            if(list.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int front = list.get(0);
            list.remove(0);
            return front;
        }

        public static int peek(){
            if(list.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return list.get(0);
        }
    }

    public static void main(String[] args) {
        Queue que = new Queue();

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);

        while(!que.isEmpty()){
            System.out.println(que.peek());
            que.remove();
        }
    }
}
