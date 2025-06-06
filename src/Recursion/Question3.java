package Recursion;

public class Question3 {
    public static int factorial(int n){

        if(n == 0 || n == 1)
            return 1;

        return n * factorial(n-1);

    }
    public static void main(String[] args) {

        // Factorial of a number n

       int n = 5;

        System.out.println(factorial(n));

    }
}
