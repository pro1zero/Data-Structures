package Arrays;
import java.util.*;
public class twoSum {

    //Time - O(N^2) | Space - O(1)
    public int[] bruteforce(int[] nums, int target){
        int[] result = new int[2];
         for(int i = 0; i < nums.length; i++){
             for(int j = i + 1; j < nums.length; j++){
                 if(nums[i] + nums[j] == target) {
                     result[0] = i;
                     result[1] = j;
                     return result;
                 }
             }
         }
         return null;
    }

    //Time - O(N) | Space - O(N) considering lookups in a hashmap is O(1)
    public int[] usingHashMaps(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }else map.put(target - nums[i], i);
        }
        return null;
    }

    //OPTIONAL - I will cover lambda expressions and Comparator class first then, I'll explain this function again.
    //Time - O(NlogN) | Space - O(N)
    public static int[] twoSumUsingTwoPointers(int[] nums, int target) {
        int[][] numsWithIndices = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            numsWithIndices[i][0] = nums[i];
            numsWithIndices[i][1] = i;
        }
        //sorting takes O(nlogn) time.
        Arrays.sort(numsWithIndices, (a, b) -> (a[0] - b[0])); 
        // for(int[] num: numsWithIndices) System.out.println(Arrays.toString(num));
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = numsWithIndices[left][0] + numsWithIndices[right][0];
            if (sum > target)
                right -= 1;
            else if(sum < target)
                left += 1;
            else return new int[]{numsWithIndices[left][1], numsWithIndices[right][1]};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(twoSumUsingTwoPointers(new int[] {4,3,2,1}, 7));
    }
}
