class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fib(n - 1);
        int slast = fib(n - 2);

        return last + slast;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        System.out.println(sol.fib(n));
    }
}