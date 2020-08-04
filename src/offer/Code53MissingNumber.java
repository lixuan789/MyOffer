package offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code53MissingNumber {
    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(nums);
    }

    private int search(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i <= mid; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt == mid + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
