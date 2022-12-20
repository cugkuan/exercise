package sort.imp;

import sort.Sort;

public class InsertSort extends Sort {
    @Override
    public void sort(int[] input) {
        for (int i = 0;i < input.length ;i++){
            var k  = getMax(i,input);
            if (k != i){
                swap(input,i,k);
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
