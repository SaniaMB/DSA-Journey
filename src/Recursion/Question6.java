package Recursion;

public class Question6 {
    public static void moveDisks(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to helper
        moveDisks(n - 1, source, destination, helper);

        // Step 2: Move nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from helper to destination
        moveDisks(n - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        // Classic problem of, Tower of Hanoi
        int n = 6;  // Number of disks
        moveDisks(n, 'A', 'B', 'C');

    }
}
