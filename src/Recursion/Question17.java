package Recursion;

import java.util.Arrays;

public class Question17 {
    public static void strings(int[] a,int n,int k){
        if(n <= 0){
            System.out.println(Arrays.toString(a));
        }else{
            for (int j = 0; j< k; j++){
                a[n-1]=j;
                strings(a,n-1,k);
            }
        }
    }
    public static void main(String[] args) {
        // Generate all the strings of length n drawn from 0…k[n-1]

        int n=2;
        int[] a = new int[n];
        strings(a,n,3);



    }
}
