package offer;


/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Code60TwoSum {
    public double[] twoSum(int n) {
        final int face = 6;//一个骰子6点
        final int pointNum = face * n;//能组合的最大点数
        int[][] dp = new int[n + 1][pointNum + 1];//dp[i][j] 表示前 i 个骰子产生点数 j 的次数
        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= pointNum; j++) {//n个骰子最小的组合是n
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final int totalNum = (int) Math.pow(6, n);
        double[] ans = new double[pointNum - n + 1];
        for (int i = n; i <= pointNum; i++) {
            ans[i - n] = (double) dp[n][i] / totalNum;
        }
        return ans;
    }

    /**
     * 简化：每个状态只与前一个有关
     *
     * @param n
     * @return
     */
    public double[] twoSum1(int n) {
        final int face = 6;//一个骰子6点
        final int pointNum = face * n;//能组合的最大点数
        int[] dp = new int[pointNum + 1];//dp[i][j] 表示前 i 个骰子产生点数 j 的次数
        for (int i = 1; i <= face; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            //从后往前更新，类似背包问题
            for (int j = 6*i; j >= i; j--) {//n个骰子最小的组合是n
                dp[j]=0;//置为0
                for (int k = 1; k <= face; k++) {
                    if (j-k<i-1){
                        break;
                    }
                    /**
                     * i表示阶段，也就是扔了几个骰子；j表示 i 这个阶段可能出现的总点数，k 是第 i 颗骰子的点数，
                     * 所以 j = k + 前 i - 1 个骰子可能出现的点数；因为前 i-1颗骰子可能出现的最小点数为 i - 1 ，
                     * 也就是每颗骰子的点数都为 1。所以j - k < i - 1 的所有情况是不合理的，也就是不可能出现的，因此就无需继续判断。
                     */

                    dp[j] += dp[j - k];
                }
            }
        }
        final int totalNum = (int) Math.pow(6, n);
        double[] ans = new double[pointNum - n + 1];
        for (int i = n; i <= pointNum; i++) {
            ans[i - n] = (double) dp[i] / totalNum;
        }
        return ans;
    }
}
