package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {13, 5, 17, 9, 1};
        System.out.println(quickSort(nums));
    }

    public static String quickSort(int[] nums){
        recur(0, nums.length - 1, nums);
        return Arrays.toString(nums);
    }

    public static void recur(int start, int end, int[] nums){
        if(start >= end) return;

        int pivot = start;
        int left = pivot + 1;
        int right = end;

        while(right >= left){
            if(nums[left] > nums[pivot] && nums[right] < nums[pivot]){
                swap(left, right, nums);
            }
            if(nums[left] <= nums[pivot]){
                left += 1;
            }
            if(nums[right] >= nums[pivot]){
                right -= 1;
            }
        }
        swap(right, pivot, nums);
        recur(start, right - 1, nums);
        recur(right + 1, end, nums);

    }

    public static void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        // a = 5, b = 3
        // a = a + b (a = 8)
        // b = a - b (8 - 3 = 5)
        // a = a - b (8 - 5 = 3)
    }
}
