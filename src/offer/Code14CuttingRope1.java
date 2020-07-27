package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class Code14CuttingRope1 {
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
        if (b == 0) return quickPow(3, a);
        if (b == 1) return quickPow(3, a - 1) * 4;
        return quickPow(3, a) * 2;
    }

    private int quickPow(int x, int pow) {
        int res = 1;
        int temp = x;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                res *= temp;
                res %= 1000000007;
            }
            temp *= temp;
            temp %= 1000000007;
            pow = pow >> 1;
        }
        return res;
    }

}
