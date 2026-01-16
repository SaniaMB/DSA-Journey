package Sorting;

public class QuickSort {

    // Quick Sort:
    // Picks a pivot, partitions the array around it, and recursively sorts the partitions.
    // Time Complexity: Average O(n log n), Worst O(n²)

    public static int[] arr = {2,4,3,5,1};

    public static void quickSort(int[] arr, int low, int high){

        if(low < high) {
           int p = partition(arr, low, high);
           quickSort(arr, low, p - 1);
           quickSort(arr, p + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

       for(int j = low; j < high; j++){
          if(arr[j] <= pivot){
              i++;
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
       }

       int temp = arr[i + 1];
       arr[i + 1] = arr[high];
       arr[high] = temp;

       return i + 1;

//        void quickSort(int[] arr, int low, int high) {
//            if (low < high) {
//                int p = partition(arr, low, high);
//                quickSort(arr, low, p - 1);
//                quickSort(arr, p + 1, high);
//            }
//        }
//
//        int partition(int[] arr, int low, int high) {
//            int pivot = arr[low];
//            int i = low;
//
//            for (int j = low + 1; j <= high; j++) {
//                if (arr[j] < pivot) {
//                    i++;
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//
//            // place pivot in correct position
//            int temp = arr[low];
//            arr[low] = arr[i];
//            arr[i] = temp;
//
//            return i;
//        }

    }

    public static void main(String[] args){
        quickSort(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");;
        }
    }
}
