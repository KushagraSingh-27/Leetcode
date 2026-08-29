class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                n++;
            } else {
                n = 0;
            }
            m = Math.max(m, n);
        }
        return m;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        Solution obj = new Solution();
        int ans = obj.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }
}