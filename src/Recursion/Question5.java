package Recursion;

public class Question5 {
    public static int calcPower(int x , int n){

        if(n == 0)
            return 1;

        if(x == 0)
            return 0;

      // return x * calcPower(x,n-1);   // TC: O(n)   SC: O(n)

        if(n % 2 == 0)
            return calcPower(x,n/2) * calcPower(x,n/2);
        else                                                              // TC: O(log n)   SC: O(log n)
            return calcPower(x,n/2) * calcPower(x,n/2) * x;

    }
    public static void main(String[] args) {

        System.out.println(calcPower(2,2));

        // System.out.println(Math.pow(2,2));
    }
}
