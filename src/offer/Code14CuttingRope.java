package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class Code14CuttingRope {
    /**
     * 动态规划
     * 最优化结构：2个乘数最大，他们的乘积也最大。
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];//最小值为1
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * Math.max(dp[j], j));
                //分段的绳子，有时候不划分的值更大。
            }
        }
        return dp[n];
    }

    /**
     * 数学方法。
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) (Math.pow(3, a - 1) * 4);
        return (int) (Math.pow(3, a) * 2);
    }

}
