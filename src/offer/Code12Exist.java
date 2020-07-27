package offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * dfs+回溯法
 */
public class Code12Exist {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        char[] chars = word.toCharArray();
        for (int i = 0; i < n; i++) {//递归入口
            for (int j = 0; j < m; j++) {
                if (dfs(board, chars, vis, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] vis, int index, int i, int j) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || i >= board.length | j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != chars[index]) {
            return false;
        }
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (dfs(board, chars, vis, index + 1, x, y)) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
}
