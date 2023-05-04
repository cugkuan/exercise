package letcode.queue;

import letcode.UtilsKt;

import java.util.*;

/**
 * 滑动窗口最大值
 */
public class SlideMax {


    public int[] maxSlideWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // 单调队列，存储的数组指针
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 先删队尾
            while (!q.isEmpty()) {
                if (nums[q.getLast()] < nums[i]) {
                    q.removeLast();
                } else {
                    break;
                }
            }
            // 入队
            q.addLast(i);
            // 范围检查，删队头
            while (!q.isEmpty()) {
                if (q.getFirst() < i - k + 1) {
                    q.removeFirst();
                } else {
                    break;
                }
            }
            // 得出最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[q.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // 输出结果是 3，3，,5，5，6,7
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] result  = new SlideMax().maxSlideWindow(nums,3);
//        UtilsKt.count(result);
        // 输出结果是 5，,7，,7，,4
        int[] nums = {3, 1, 5, 7, 4, 2, 1};
        int[] result = new SlideMax().maxSlideWindow(nums, 3);
        UtilsKt.count(result);
    }
}
