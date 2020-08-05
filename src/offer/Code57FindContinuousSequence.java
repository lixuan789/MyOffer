package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 */
public class Code57FindContinuousSequence {
    /**
     * 双指针
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int low = 1;
        int high = 2;
        ArrayList<int[]> list = new ArrayList<>();
        while (low < high && high <= target) {
            int num = (low + high) * (high - low + 1);
            if (num == 2 * target) {
                int[] temp = getArray(low, high);
                list.add(temp);
                high++;
            } else if (num < 2*target) {
                high++;
            } else if (num>2*target){
                low++;
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int[] getArray(int low, int high) {
        int[] ans = new int[high - low + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + low;
        }
        return ans;
    }

    public static void main(String[] args) {
        Code57FindContinuousSequence test = new Code57FindContinuousSequence();
        int[][] sequence = test.findContinuousSequence(9);
        for (int i=0;i<sequence.length;i++){
            System.out.println(Arrays.toString(sequence[i]));
        }
    }
}
