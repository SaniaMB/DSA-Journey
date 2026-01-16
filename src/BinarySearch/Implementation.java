package BinarySearch;

public class Implementation {
    public static int linearSearch(int[] nums , int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] nums , int target,int left,int right){

        int mid = (left + right)/2;

       if(nums[mid] == target) return mid;
       if(target > nums[mid]) return binarySearch(nums,target,mid + 1,right);
       if(target < nums[mid]) return binarySearch(nums,target,left,mid - 1);

       return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,8,9,34,55,67,78};
        int target = 6;

        System.out.println(linearSearch(arr,target));
        System.out.println(binarySearch(arr,target,0,arr.length-1));
    }
}
