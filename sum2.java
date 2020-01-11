import java.util.*;
/**  Question
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
**/

class sum2 {

	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		System.out.println(twoSum(nums,9).toString());
	}
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        int i;
        for(i = 0;i<nums.length;i++) {
            tempMap.put(new Integer(nums[i]),new Integer(i));
        }
        for(i = 0;i<nums.length;i++) {
            int val = target - nums[i];
            if(tempMap.containsKey(new Integer(val))) {
                int b = tempMap.get(new Integer(val)).intValue();
                if(b == i) {
                    continue;
                }
                int[] a = {i,tempMap.get(new Integer(val)).intValue()};
                return a;
            }
        }
        return new int[2];
    }
}
