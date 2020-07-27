package offer;
/**
 * @author LiXxuan
 * @date 2020/7/24 11:07
 */
import utils.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code06ReversePrint {
    /**
     * 方法一：利用栈实现反转
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            res[index++] = num;
        }
        return res;
    }

    /**
     * 方法二：使用头插法
     *
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode p = head;
        int len = 0;
        while (p != null) {//头插法
            len++;
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        int[] res = new int[len];
        int index = 0;
        p = dummy.next;
        while (p != null) {
            res[index++] = p.val;
            p = p.next;
        }
        return res;
    }
}
