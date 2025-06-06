package Recursion;

public class Question1 {
    public static void printNum(int n){

        if(n == 0)    // Base case,   n==6
            return;

        System.out.println(n);

        printNum(n-1);  // recursive call   n+1
    }
    public static void main(String[] args) {
        // Recursion happens in stack
        // Print Numbers 5-1 using recursion
        // Print Numbers 1-5 using recursion

        int n = 5;     //  n = 1
        printNum(n);
    }
}
