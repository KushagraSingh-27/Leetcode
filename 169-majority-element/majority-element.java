class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int c = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            if (c == 0) {
                c = 1;
                e = nums[i];
            } else if (e == nums[i]) {
                c++;
            } else {
                c--;
            }
        }
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == e) {
                c1++;
            }
        }
        if (c1 > (n / 2)) {
            return e;
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        Solution sol = new Solution();
        int ans = sol.majorityElement(a);
        System.out.println(ans);
    }
}
