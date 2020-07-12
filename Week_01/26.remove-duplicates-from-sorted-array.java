/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    // public int removeDuplicates(int[] nums) {
    //     int j = 0;
    //     for (int i=1; i<nums.length; i++) {
    //         if (nums[i] != nums[j]) {
    //             nums[++j] = nums[i];
    //         }
    //     }
    //     return j++;
    // }

    public int removeDuplicates(int[] nums) {
        int cur = 0 ; 
        for(int n:nums)
            if(n>nums[cur])
                nums[++cur] = n;
        return cur+1;
    }


}
// @lc code=end

