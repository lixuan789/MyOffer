package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Code38Permutation {
    ArrayList<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        boolean[] vis = new boolean[s.length()];
        Arrays.sort(chars);
        dfs(chars, vis, new StringBuilder());
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void dfs(char[] chars, boolean[] vis, StringBuilder temp) {
        if (temp.length() == chars.length) {
            list.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (vis[i] == true) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && vis[i - 1] == false) {
                continue;
            }
            vis[i] = true;
            temp.append(chars[i]);
            dfs(chars, vis, temp);
            temp.deleteCharAt(temp.length() - 1);
            vis[i] = false;
        }
    }
}
