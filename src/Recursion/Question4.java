package Recursion;

public class Question4 {
    public static int fibonacci(int n){

        if( n == 0)
            return 0;

        if(n == 1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);

    }
    public static void main(String[] args) {
        // Fibonacci series till nth term

        int n = 10;

        for (int i = 0; i < n; i++) {
           System.out.print(fibonacci(i) + " ");
       }

       /* int a = 0;
        int b = 1;

        System.out.println(a);
        System.out.println(b);
        for(int i = 2; i < n; i++){
            int c = a + b;
            a = b;
            b= c;
            System.out.println(c);
        } */

    }
}
