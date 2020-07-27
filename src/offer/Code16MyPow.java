package offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 */
public class Code16MyPow {
    /**
     * 快速幂算法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return quickPow1(x, n);
    }

    private double quickPow1(double x, int n) {
        double res = 1;
        double temp = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        return res;
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = quickPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
