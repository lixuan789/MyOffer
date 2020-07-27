package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LiXxuan
 * @date 2020/7/27 18:04
 */

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });//大顶堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int N = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (N % 2 == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        N++;
    }

    public double findMedian() {
        if (N % 2 == 0) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
