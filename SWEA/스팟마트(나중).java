//https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
//여기서 current를 지금 숫자 아니면 bi 갯수만큼 2^i개의 dp를 더함..

class Solution13_DP{
    // DP solution to calculate the maximum sum in a given array
    // with no adjacent elements considered (function uses an extra space)
    public static int findMaxSumSubsequence(int[] nums)
    {
        int n = nums.length;

        // base case
        if (n == 0) {
            return 0;
        }

        // base case
        if (n == 1) {
            return nums[0];
        }

        // create an auxiliary array to store solutions to subproblems
        int[] dp = new int[n];

        // dp[i] stores the maximum sum possible till index `i`

        // trivial case
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);

        // traverse array from index 2
        for (int i = 2; i < n; i++)
        {
            // dp[i] stores the maximum sum we get by

            // 1. Excluding the current element and take maximum sum until index `i-1`
            // 2. Including the current element nums[i] and take the maximum sum
            //    till until i-2
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);

            // if the current element is more than the maximum sum until the current
            // element
            dp[i] = Integer.max(dp[i], nums[i]);
        }

        // return maximum sum
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.print("The maximum sum is " + findMaxSumSubsequence(nums));
    }
    /**
     * // Function to calculate the maximum sum in a given array
     *     // with no adjacent elements considered
     *     // `i` ——> index of the current element
     *     // `prev` ——> index of the previous element included in the sum
     *     public static int findMaxSumSubsequence(int[] nums, int i, int n, int prev)
     *     {
     *         // base case: all elements are processed
     *         if (i == n) {
     *             return 0;
     *         }
     *
     *         // recur by excluding the current element
     *         int excl = findMaxSumSubsequence(nums, i + 1, n, prev);
     *
     *         int incl = 0;
     *
     *         // include current element only if it's not adjacent to
     *         // the previous element
     *         if (prev + 1 != i) {
     *             incl = findMaxSumSubsequence(nums, i + 1, n, i) + nums[i];
     *         }
     *
     *         // return maximum sum we get by including or excluding
     *         // current item
     *         return Integer.max(incl, excl);
     *     }
     *
     *     public static void main(String[] args)
     *     {
     *         int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
     *         System.out.print("The maximum sum is "
     *                 + findMaxSumSubsequence(nums, 0, nums.length, Integer.MIN_VALUE));
     *     }
     */

}
