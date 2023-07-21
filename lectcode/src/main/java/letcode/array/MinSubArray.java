package letcode.array;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：

输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。


 */

class MinSubArray{
    int minSubArray(int[] array,int s){
        int sum = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        for (int j = 0; j < array.length;j++){
            sum+= array[j];
            while (sum >= s){
                len = Math.min(len,j-i +1);
                sum -= array[i++];
            }
        }
        return len == Integer.MAX_VALUE? 0:len;
    }
    public static void main(String[] args){
        int[] arrays = new int[]{2,3,1,2,4,3};
        System.out.println(new MinSubArray().minSubArray(arrays,7));
    }
}
