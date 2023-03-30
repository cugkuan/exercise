package sort.imp;

import sort.Sort;

/**
 * 左闭右闭，可以减少麻烦;
 * 这个其实很简答，没啥可以说的，关键是一路归并的逻辑
 */
public class MergeSort extends Sort {
    @Override
    public void sort(int[] input) {
        int[] temp = new int[input.length];
        internalMergeSort(input,temp,0,input.length-1);
    }
    private void internalMergeSort(int[] input,int[] temp,int left,int right){
        if (left < right){
            int middle = (left + right)/2;
            internalMergeSort(input,temp,left,middle);
            internalMergeSort(input,temp,middle+1,right);
            merge(input,temp,left,middle,right);
        }
    }
    private void merge(int[] input,int[] temp,int left,int middle,int right){
        int i = left;
        int j =  middle + 1;
        int tempIndex = i;
        while (i <= middle && j <= right){
            if (input[i] < input[j]){
                temp[tempIndex] = input[i];
                i++;
            }else {
                temp[tempIndex] = input[j];
                j++;
            }
            tempIndex ++;
        }
        while (i <= middle){
            temp[tempIndex] = input[i];
            i++;
            tempIndex++;
        }
        while (j <= right){
            temp[tempIndex] = input[j];
            j++;
            tempIndex++;
        }
        // 将数据复制回去
        for (int c = left; c <= right ;c++){
            input[c] = temp[c];
        }
    }

    public static void main(String[] args) {
        new MergeSort().sort(input);
        count(input);
    }


}
