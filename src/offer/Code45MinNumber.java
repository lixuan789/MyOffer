package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Code45MinNumber {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        int n = nums.length;
        String[] temp = new String[n];
        for (int i = 0; i < n; i++)
            temp[i] = nums[i] + "";
        Arrays.sort(temp, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : temp)
            ret += str;
        return ret;
    }
}
