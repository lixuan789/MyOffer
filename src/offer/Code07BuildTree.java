package offer;

import utils.TreeNode;


/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code07BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        TreeNode root = build(preorder, 0, n - 1, inorder, 0, n - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend || pstart >= preorder.length || istart >= preorder.length) {
            return null;
        }
        int num = preorder[pstart];
        TreeNode root = new TreeNode(num);
        int count = 0;
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == num) {
                break;
            }
            count++;
        }
        root.left = build(preorder, pstart + 1, pstart + count, inorder, istart, istart + count - 1);
        root.right = build(preorder, pstart + count + 1, pend, inorder, istart + count + 1, iend);
        return root;
    }


}
