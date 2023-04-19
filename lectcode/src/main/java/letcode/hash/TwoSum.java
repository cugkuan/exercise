package letcode.hash;

/**
 * 二个数之和；
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */

import letcode.UtilsKt;

import java.util.HashMap;
/**
 * 这个题放到这里，是因为思想很有意思的；
 *
 * 四个数之后，也是类似的思想
 */
public class TwoSum {

    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i <nums.length;i++){
            int hope = target - nums[i];
            if (hashMap.containsKey(hope)){
                result[0] = hashMap.get(hope);
                result[1] = i;
                return  result;
            }
            hashMap.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args){

        int[] r = new TwoSum().twoSum(new int[]{2, 7, 11, 15},9);
        UtilsKt.count(r);
    }
}
