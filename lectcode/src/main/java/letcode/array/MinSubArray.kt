package letcode.array

import kotlin.math.min


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：

输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。


 */

fun minSubArray(nums:IntArray,s:Int):Int{
    var i = 0
    var sum  = 0
    var subLen = Int.MAX_VALUE
    for (j in nums.indices){
        sum+= nums[j]
        while (sum >= s){
            if (sum == s){
                subLen = min(subLen,j-i+1)
            }
            sum -= nums[i++]
        }
    }
    return if (subLen == Int.MAX_VALUE) 0 else subLen
}

fun main(){
    println(minSubArray(intArrayOf(2,3,1,2,4,3),7))
}