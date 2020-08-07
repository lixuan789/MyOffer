package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Deque<Integer> maxqueue;//存最大值
    Deque<Integer> data;//存数据

    public MaxQueue() {
        maxqueue = new ArrayDeque<>();
        data = new ArrayDeque<>();
    }

    public int max_value() {
        return maxqueue.isEmpty() ? -1 : maxqueue.peek();
    }

    public void push_back(int value) {
        data.offer(value);
        while (!maxqueue.isEmpty() && maxqueue.peekLast() < value) {
            maxqueue.pollLast();
        }
        maxqueue.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int val = data.pollFirst();
        if (val == maxqueue.peekFirst()) {
            maxqueue.pollFirst();
        }
        return val;
    }
}
