package offer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * dfs
 */
public class Code13MovingCount {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        boolean[][] vis = new boolean[m][n];
        int ans=dfs(m, n, k, vis, 0, 0);
        return ans;
    }

    private int dfs(int m, int n, int k, boolean[][] vis, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || getNum(i, j) > k) {
            return 0;
        }
        vis[i][j] = true;
        int res=1;
        for (int p = 0; p < 4; p++) {
            int x = i + dx[p];
            int y = j + dy[p];
            res+=dfs(m, n, k, vis, x, y);
        }
        return res;
    }

    private int getNum(int i, int j) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        while (j != 0) {
            res += j % 10;
            j /= 10;
        }
        return res;
    }
}
