package letcode.array

import letcode.count
/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
fun removeDuplicates(nums: IntArray): IntArray {
    var i = 0
    for (j in 1 until  nums.size){
        if (nums[i] != nums[j]){
            i++;
            nums[i] = nums[j]
        }
    }
    return  nums.copyOfRange(0,i+1)
}
/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/submissions/
 */
fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 0
    var j = numbers.size  -1
    while (i < j){
        val sum = numbers[i] + numbers[j]
        when {
            sum < target -> i++
            target == sum -> return intArrayOf(i,j)
            else -> j--
        }
    }
    return intArrayOf()

}

fun main(){

//    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
//    count(removeDuplicates(nums))

    val nums = intArrayOf(5,25,75)
    count( twoSum(nums,100))
    count( twoSum(intArrayOf(2,7,11,15),9))

}