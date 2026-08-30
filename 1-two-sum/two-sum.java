class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] n1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            n1[i][0] = nums[i];
            n1[i][1] = i;
        }
        Arrays.sort(n1, (a, b) -> Integer.compare(a[0], b[0]));
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = n1[l][0] + n1[r][0];
            if (sum == target) {
                return new int[] {n1[l][1], n1[r][1]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {-1, -1};
    }
}