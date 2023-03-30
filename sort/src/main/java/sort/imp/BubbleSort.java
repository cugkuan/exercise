package sort.imp;

import sort.Sort;

/**
 * 冒泡排序
 */
public class BubbleSort extends Sort {
    @Override
    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0;j < input.length - i - 1;j++){
                if (input[j] > input[j+1]){
                    swap(input,j,j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        new BubbleSort().sort(input);
        count(input);
    }
}


