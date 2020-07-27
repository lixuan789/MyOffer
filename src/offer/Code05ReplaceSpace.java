package offer;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Code05ReplaceSpace {
    /**
     * 方法一：利用API
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    /**
     * 方法二：一个空格字符串长度多2
     * 1.先利用空格数计算最后字符串的长度
     * 2.从后往前天字符。遇到空格进行替换
     *
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        int n = s.length();
        int num = 0;//空格数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                num++;
            }
        }
        char[] res = new char[n + 2 * num];
        int index = n + 2 * num - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            } else {
                res[index--] = chars[i];
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Code05ReplaceSpace test = new Code05ReplaceSpace();
        String we_are_happy = test.replaceSpace1("We are happy.");
        System.out.println(we_are_happy);
    }
}
