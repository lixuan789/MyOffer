package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Code51ReversePairs {
    /**
     * 暴力法:超时
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    private int res = 0;

    /**
     * 分治法
     *
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp=new int[high-low+1];
        int p1=low;
        int p2=mid+1;
        int i=0;
        while (p1<=mid&&p2<=high){
            if (nums[p1]>nums[p2]){
                temp[i++]=nums[p2++];
                int num=mid-p1+1;
                res+=num;
            }else {
                temp[i++]=nums[p1++];
            }
        }
        while (p1<=mid){
            temp[i++]=nums[p1++];
        }
        while (p2<=high){
            temp[i++]=nums[p2++];
        }
        for (int j=0;j<temp.length;j++){
            nums[j+low]=temp[j];
        }
    }
}
