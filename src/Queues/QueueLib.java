package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLib{
    // Queue implementation using java framework collection

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println();
        q.add(5);
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println(q.peek());
    }
}
