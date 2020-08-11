import java.util.HashMap;
import java.util.Map;

class Solution { // 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
    public static void main(String[] args) {
        System.out.println(new Solution().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        int[] sum = new int[length + 1];
        Map<Integer, Integer> beforeSumAndIndex = new HashMap<>();
        beforeSumAndIndex.put(0, 0);
        for (int index = 1; index <= length; ++index) {
            sum[index] = sum[index - 1] + nums[index - 1];
            dp[index] = dp[index - 1];
            Integer getData = beforeSumAndIndex.get(sum[index] - target); // find the value index which will be started
            if (getData != null) {
                dp[index] = Math.max(dp[getData] + 1, dp[index]);
            }
            beforeSumAndIndex.put(sum[index], index);
        }

        return dp[length];
    }
}