package Sorting;

public class BubbleSort {
    // Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
    // The pass through the list is repeated until the list is sorted.

    // TC = O(n ^ 2)
    // Best TC = O(n)
    // SC = O(1)

    static int[] nums = {1,2,3,5,9};

    public static void sort(int[] nums){
        int n = nums.length;
        boolean swapped;

        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(nums[j] > nums[j +1]){
                   int temp = nums[j];
                   nums[j] = nums[j + 1];
                   nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args){
        sort(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");;
        }
    }
}
