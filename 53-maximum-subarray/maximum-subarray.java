class Solution {
    public int maxSubArray(int[] nums) {
        long m = Long.MIN_VALUE; 
        long s = 0; 
        for (int i = 0; i < nums.length; i++) {
            s+= nums[i]; 
            if (s > m) {
                m = s; 
            }
            if (s < 0) {
                s = 0; 
            }
        }
        return (int) m;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        Solution sol = new Solution();
        int maxSum = sol.maxSubArray(arr);
        System.out.println(maxSum);
    }
}
