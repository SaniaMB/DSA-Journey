package Recursion;

public class Question2 {
    public static int sum(int n){
        if(n == 1)
            return 1;

        return n + sum(n-1);
    }
    public static void main(String[] args) {
        // Print sum of n natural numbers

        int n = 10;
        System.out.println(sum(n));

    }
}
