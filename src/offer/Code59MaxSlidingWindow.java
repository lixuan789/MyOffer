package offer;

import java.util.*;

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

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums==null||nums.length==0){
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dequeue=new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            while (!dequeue.isEmpty()&&nums[dequeue.peekLast()]<nums[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            if (dequeue.peekFirst()+k<=i){
                dequeue.pollFirst();
            }
            if (i+1>=k){
                list.add(nums[dequeue.peekFirst()]);
            }
        }
        int[] ans=new int[list.size()];
        for (int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Code59MaxSlidingWindow test = new Code59MaxSlidingWindow();
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] a = test.maxSlidingWindow1(nums, 3);
        System.out.println(Arrays.toString(a));
    }
}
