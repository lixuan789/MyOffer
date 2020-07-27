package offer;


import org.w3c.dom.Node;

import java.util.Stack;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Code36TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        inorder(root);
        pre.left = head;
        head.right = pre;
        return head;
    }

    /**
     * 递归
     *
     * @param root
     */
    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inorder(root.right);
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return root;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null, head = null, cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            node.left = pre;
            if (pre != null) {
                pre.right = node;
            } else {
                head = node;
            }
            pre = node;
            cur = node.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }


}
