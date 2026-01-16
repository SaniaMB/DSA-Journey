package Sorting;

public class MergeSort {
    // Merge Sort is a divide-and-conquer algorithm that divides the unsorted list into n sublists, each containing one element,
    // and then repeatedly merges sublists to produce new sorted sublists until there is only one sublist remaining.

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)

    static int[] nums = {5, 2, 4, 1, 3};

    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        int idx = left;

        for(int x = 0; x < temp.length; x++){
            arr[idx] = temp[x];
            idx++;
        }

    }

    public static void main(String[] args) {
        mergeSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
