package offer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code43CountDigitOne {
    /**
     * 先算个位，再十位、、、依次内推。
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0;
        long m = 10;
        while (true) {
            int a = (int) (n / m);
            int b = (int) (n % m);
            int first = (int) (b / (m / 10));//b的最高位
            res += ((first + 8) / 10 + a) * (m / 10);
            res += (first == 1 ? b % (m / 10) + 1 : 0);
            m = m * 10;
            if (a == 0) {
                break;
            }
        }
        return res;
    }
}
