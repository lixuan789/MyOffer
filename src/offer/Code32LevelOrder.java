package offer;

import utils.TreeNode;

import java.util.*;

public class Code32LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (index % 2 == 1) {
                ret.add(temp);
            } else {
                Collections.reverse(temp);
                ret.add(temp);
            }
            index++;
        }
        return ret;
    }
}
