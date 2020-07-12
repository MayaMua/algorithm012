/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
import java.util.Arrays;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int value = target-nums[i];
            if (map.containsKey(value)) {
                return new int [] {map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

