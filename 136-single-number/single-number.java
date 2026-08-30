class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int range = max - min + 1;
        int[] single = new int[range];
        for (int i = 0; i < nums.length; i++) {
            single[nums[i] - min]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (single[nums[i] - min] == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}