package Sorting;

import java.util.Arrays;

public class HeapSortAlgo {    // O(n log n)

    public static void sort(int[] arr){
        int N = arr.length;

        for(int i = N/2 - 1; i >= 0; i--){
            heapify(arr, N, i);
        }

        for(int i = N -1; i > 0; i--){

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int N, int i){   // O(n)

        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if( left < N && arr[largest] < arr[left])
            largest = left;

        if( right < N && arr[largest] < arr[right])
            largest = right;

        if( largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, N, largest);

        }
    }

    public static void main(String[] args){
        int[] arr = {1,12,9,5,6,10};

        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
