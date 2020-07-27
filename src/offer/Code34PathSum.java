package offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code34PathSum {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }
        dfs(root, sum, new ArrayList<Integer>());
        return ret;
    }

    private void dfs(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root!=null&&sum==root.val&&root.left==null&&root.right==null){
            path.add(root.val);
            ret.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        if (root==null&&sum!=0){
            return;
        }
        if (root!=null){
            path.add(root.val);
            sum-=root.val;
            dfs(root.left, sum, path);
            dfs(root.right, sum, path);
            sum+=root.val;
            path.remove(path.size() - 1);
        }
    }
}
