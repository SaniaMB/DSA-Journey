package Sorting;

//A sorting algorithm is an algorithm that organizes elements in a specific order.
// The most common orders are numerical or lexicographical.

public class SelectionSort {
    // Selection Sort: A sorting algorithm that repeatedly selects the smallest element
    // from the unsorted part and places it at the correct position.

    // TC = O(n ^ 2)
    // SC = O(1)

    static int[] nums = {2,4,3,5,1};

    public static void sort(int[] nums){
        int n = nums.length;

        for(int i = 0; i < n -1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public static void main(String[] args){
        sort(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");;
        }
    }
}
