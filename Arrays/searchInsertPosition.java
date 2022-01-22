package Arrays;

public class searchInsertPosition{

    //Time - O(N) | Space - O(1)
    public static int linearTime(int[] nums, int target){
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }

    //Time - O(logN) | Space - O(1)
    public static int searchInsertOptimal(int[] nums, int target) {
        int left = 0, right = nums.length -1, mid = -1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return nums[mid] < target ? mid + 1 : mid;
        // nums[mid] = 10 < target = 18 (yes) ? mid + 1 = 4 : mid = 3;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertOptimal(new int[] {1, 5, 7, 10}, 9));
    }
}