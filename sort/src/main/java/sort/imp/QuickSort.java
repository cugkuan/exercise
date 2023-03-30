package sort.imp;

import sort.Sort;

/**
 * 注意，先右边，再左边
 * 注意一些细节问题
 */
public class QuickSort extends Sort {
    @Override
    public void sort(int[] input) {
        internalQuickSort(input, 0, input.length - 1);
    }

    /**
     * 左闭右闭，减少复杂度
     *
     * @param input
     * @param left
     * @param right
     */
    private void internalQuickSort(int[] input, int left, int right) {
        if (left < right) {
            int key = input[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && input[j] > key) {
                    j--;
                }
                while (i < j && input[i] < key) {
                    i++;
                }
                // 下面这行代码关键
                if (input[i] == input[j]) {
                    j--;
                } else {
                    swap(input, i, j);
                }
            }
            internalQuickSort(input, left, i);
            internalQuickSort(input, i + 1, right);
        }
    }

    public static void main(String[] args) {
        new QuickSort().sort(input);
        count(input);


    }
}
