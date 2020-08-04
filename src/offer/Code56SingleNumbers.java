package offer;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Code56SingleNumbers {
    /**
     * 两个数进行异或操作为0
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int base = 1;
        while ((res & 1) != 1) {
            base <<= 1;
            res >>= 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & base) != 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = num1;
        ans[1] = num2;
        return ans;
    }
}
