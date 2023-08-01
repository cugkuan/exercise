package exercise;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-string-after-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumBinaryString {

    /**
     * 分析 00 -> 10 ,说明一个字符串，经过n次变化后，这个字符串只剩下 一个 0。
     * 10 -> 01 只表示能交换位置而已。
     * 那么变化的最大值，就是求 0 在字符串的位置而已。
     * 最大值一定是 0 越往左边了，值越大。
     * @param binary
     * @return
     */
    public String maximumBinaryString(String binary) {
        int begin = -1;
        int count = 0;
        for (int i = 0;i < binary.length() ;i++){
            if (binary.charAt(i) == '0'){
                count++;
                if (begin == -1){
                    begin = i;
                }
            }
        }
        if (count < 2){
            return binary;
        }
        char[] result  = new char[binary.length()];
        Arrays.fill(result,'1');
        result[begin+count-1] = '0';
        return new String(result);
    }

    public static void main(String[] args){
        var test = new MaximumBinaryString();

        System.out.println(test.maximumBinaryString("000110"));
        System.out.println(test.maximumBinaryString("01"));
    }

}
