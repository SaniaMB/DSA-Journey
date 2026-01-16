package Sorting;

public class InsertionSort {
    // Insertion Sort:
    // Builds a sorted portion of the array by inserting each element
    // into its correct position.
    // Time Complexity: Best O(n), Average O(n²), Worst O(n²)


    public static int[] nums = {2,4,3,5,1};

    public static void insertionSort(int[] nums){

        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args){
        insertionSort(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");;
        }
    }
}
