package offer;

import java.util.LinkedList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class FirstAppearingOnce {
    private int[] cnt = new int[256];
    private LinkedList<Character> queue = new LinkedList<>();

    public void insert(char ch) {
        cnt[ch]++;
        queue.addLast(ch);
        while (!queue.isEmpty() && cnt[queue.peek()] > 1) {
            queue.removeFirst();
        }
    }

    public char firstAppearingOnce() {
        return queue.peek();
    }
}
