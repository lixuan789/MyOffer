package offer;

import java.util.Stack;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code46TranslateNum {
    private int res=0;
    /**
     * DFS
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num<0){
            return 0;
        }
        //转化为数组
        Stack<Integer> stack=new Stack<>();
        while (num!=0){
            stack.push(num%10);
            num/=10;
        }
        int[] nums=new int[stack.size()];
        int index=0;
        while (!stack.isEmpty()){
            nums[index]=stack.pop();
            index++;
        }
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if (i>=nums.length){
            res++;
            return;
        }
        dfs(nums,i+1);
        if (i<nums.length-1&&nums[i]!=0){
            int num=nums[i]*10+nums[i+1];
            if (num<=25){
                dfs(nums,i+2);
            }
        }
    }

    public static void main(String[] args) {
        Code46TranslateNum test = new Code46TranslateNum();
        int i = test.translateNum(506);
        System.out.println(i);
    }
}
