package offer;

public class Code47MaxValue {
    /**
     * 滚动数组：每个状态只跟前一个相关
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
                if (i == 0) {
                    dp[j] = sum;
                    continue;
                }
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1];
    }
}
