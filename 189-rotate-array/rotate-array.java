class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    } 
    private void reverse(int[] nums, int v, int m) {
        while (v < m) {
            int q = nums[v];
            nums[v] = nums[m];
            nums[m] = q;
            v++;
            m--;
        }
    }
}