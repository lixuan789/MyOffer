package offer;

import java.util.ArrayList;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code44FindNthDigit {
    /**
     * 方法：
     *      1位：1-9      1*9个(有个0没算)
     *      2位：10-99    2*90个
     *      3位：100-999  3*900个
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int base = 1;
        long cnt = 9;
        int res = 0;
        while (true) {
            long temp = base * cnt;
            if (res + temp >= n) {
                int last = n - res - 1;//剩余的部分、还要第一个0也要减
                long num = cnt / 9 + last / base;
                ArrayList<Integer> list = new ArrayList<>();
                while (num != 0) {
                    list.add((int) (num % 10));
                    num /= 10;
                }
                int len = list.size() - 1;
                return list.get(len - last % base);
            }
            res+=temp;
            base++;
            cnt *= 10;
        }
    }

    public static void main(String[] args) {
        Code44FindNthDigit digit = new Code44FindNthDigit();
        int i = digit.findNthDigit(1000000000);
        System.out.println(i);
    }
}
