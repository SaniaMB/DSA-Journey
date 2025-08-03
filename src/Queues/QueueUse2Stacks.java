package Queues;

import java.util.Stack;

public class QueueUse2Stacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }

        public static void add(int data){

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(isEmpty()) return -1;

            return s1.pop();
        }

        public static int peek(){
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue qu = new Queue();

        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);

        while (!qu.isEmpty()) {
            System.out.println(qu.peek());
            qu.remove();
        }
    }
}
