package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Code59MaxSlidingWindow {
    /**
     * 大顶堆
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < k; i++)
            heap.add(nums[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + k; j < nums.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(nums[i]);
            heap.add(nums[j]);
            ret.add(heap.peek());
        }
        int[] ans=new int[ret.size()];
        for (int i=0;i<ans.length;i++){
            ans[i]=ret.get(i);
        }
        return ans;
    }
}
