package sort.imp;

import sort.Sort;

/**
 * 扑克牌的思想
 */
public class InsertSort extends Sort {
    @Override
    public void sort(int[] input) {
        for (int i = 0;i < input.length;i++){
            int index = getMax(i,input);
            if (index != i){
                swap(input,index,i);
            }
        }
    }
    private int getMax(int begin,int[] input){
        var max  = input[begin];
        var j = begin;
        for (var i = begin ;i < input.length;i++ ){
            if (input[i] > max){
                max = input[i];
                j = i;
            }
        }
        return j;
    }
    public static void main(String[] args){
        new InsertSort().sort(input);
        count(input);
    }
}
