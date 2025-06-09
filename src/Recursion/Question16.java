package Recursion;

public class Question16 {
    public static void generateBinaryStrings(int[] A, int n, int index){
        if (index == n) {
            // Print the array
            for (int bit : A) {
                System.out.print(bit);
            }
            System.out.println();
            return;
        }

        // Set A[index] to 0 and recurse
        A[index] = 0;
        generateBinaryStrings(A, n, index + 1);

        // Set A[index] to 1 and recurse
        A[index] = 1;
        generateBinaryStrings(A, n, index + 1);
    }
    public static void main(String[] args) {
        // Generate all strings of n bits. Assume A[0....n-1] is an array of size n.
        int n = 3;  // You can change this value to generate n-bit strings
        int[] A = new int[n];
        generateBinaryStrings(A, n, 0);
    }
}
