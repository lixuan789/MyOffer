package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Code53Search {
    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = BinarySearch(nums, target - 0.5);
        int right = BinarySearch(nums, target + 0.5);
        return right - left;
    }

    private int BinarySearch(int[] nums, double target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Code53Search test = new Code53Search();
        int[] nums={5,7,7,8,8,10};
        int i = test.search(nums, 8);
        System.out.println(i);
    }
}
