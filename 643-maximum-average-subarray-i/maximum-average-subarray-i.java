class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long Sum =0;
        for (int i=0; i<k;i++){
            Sum= Sum+ nums[i];
        }
        long maximum = Sum;

        for (int i=k; i< nums.length;i++){
            Sum+=nums[i]-nums[i-k];
            maximum = Math.max(maximum,Sum);
        }
        return (double) maximum/k;

        
    }
}