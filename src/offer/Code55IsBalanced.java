package offer;

import utils.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Code55IsBalanced {
    private boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return flag;
    }

    private int helper(TreeNode root) {
        if (root==null||flag==false){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        if (Math.abs(left-right)>1){
            flag=false;
        }
        return 1+Math.max(left,right);
    }
}
