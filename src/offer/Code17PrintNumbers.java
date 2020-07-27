package offer;

import java.util.ArrayList;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Code17PrintNumbers {
    private ArrayList<Integer> res = new ArrayList<>();

    public int[] print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return null;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
        int[] temp = new int[res.size()];
        int index = 0;
        for (Integer num : res) {
            temp[index++] = num;
        }
        return temp;
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            int num = printNumber(number);
            if (num!=0){
                res.add(num);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private int printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        int num = 0;
        while (index < number.length) {
            num = num * 10 + (number[index] - '0');
            index++;
        }
        return num;
    }
}
