package sort.imp;

import sort.Sort;

public class MergeSort extends Sort {
    @Override
    public void sort(int[] input) {
        int[] assist = new int[input.length];
        internalSort(input,0,input.length-1,assist);
    }
    private void internalSort(int[] input,int left,int right, int[] assist){
        if (left < right){
            int middle = (left + right)/2;
            internalSort(input,left,middle,assist);
            internalSort(input,middle+1,right,assist);
            merge(input,left,middle,right,assist);
        }
    }
    private void merge(int[] input ,int left,int middle,int right, int[] assist){
        int i = left;
        int j = middle +1;
        int temp = i;
        while (i <= middle && j <= right){
            if (input[i] < input[j]){
                assist[temp] = input[i];
                i++;
            }else {
                assist[temp] = input[j];
                j++;
            }
            temp++;
        }
        // 复制左边
        while (i <= middle){
            assist[temp] = input[i];
            temp++;
            i++;
        }
        // 复制右边
        while (j <= right){
            assist[temp] = input[j];
            temp++;
            j++;
        }
        // 将数据复制回去
        for (int c = left; c<= right ;c++){
            input[c] = assist[c];
        }
    }
    public static void main(String[] args){
        new MergeSort().sort(input);
        count(input);
    }


}
