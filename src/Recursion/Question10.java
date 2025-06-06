package Recursion;

public class Question10 {
    public static boolean checkSort(int[] arr, int n){

        if(n == arr.length-1)
            return true;

        if( arr[n] >= arr[n+1])
            return false;

        return checkSort(arr,n+1);

    }
    public static void main(String[] args) {

        // Check if an array is sorted (In increasing order)

       int[] arr = {2,2,4,6,8};

        System.out.println(checkSort(arr,0));

    }
}
