package offer;

public class Code33VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        if (postorder == null || n == 0) {
            return true;
        }
        return dfs(postorder, 0, n - 1);
    }

    private boolean dfs(int[] postorder, int l, int h) {
        if (l > h) {
            return true;
        }
        int root = postorder[h];
        int i = l;
        for (; i <= h - 1; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int mid = i;
        for (; i <= h - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return dfs(postorder, l, mid - 1) && dfs(postorder, mid, h - 1);
    }
}
