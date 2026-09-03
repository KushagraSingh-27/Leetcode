class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            else {
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }
}
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
