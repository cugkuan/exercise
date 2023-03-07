package sort.imp;

import sort.Sort;

/**
 * 冒泡排序
 */
public class BubbleSort extends Sort {

    @Override
    public void sort(int[] input) {
        for (int i = 0;i < input.length;i++){
            for (var j = 1;j < input.length - i;j++){
                if (input[j-1] > input[j]  ){
                    swap(input,j-1,j);
                }
            }
        }
    }
    public static void main(String[] args){
        new BubbleSort().sort(input);
        count(input);
    }
}


