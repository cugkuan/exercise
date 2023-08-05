package exercise;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 发牌面的问题
 * 去除 雀牌后。还剩下 12张牌。于是有：
 * 这12 确实顺子和三张重复的。
 * 哈希记录出现的次数;其实就是哈希记录.另一个就是回溯的思想。非常的重要！！！！！！
 */
public class Byte4 {
    private static  boolean run(int[] nums){
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if (count == 0){
            return true;
        }
        for (int i = 0; i < 9 ;i++) {
            // 找刻子
            if (nums[i] >= 3) {
                nums[i] -= 3;
                if (run(nums)) {
                    return true;
                }
                nums[i] += 3;
            }
            // 找顺子
            if (i < 7 && nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0) {
                nums[i] -= 1;
                nums[i + 1] -= 1;
                nums[i + 2] -= 1;
                if (run(nums)) {
                    return true;
                }
                nums[i] += 1;
                nums[i + 1] += 1;
                nums[i +2] += 1;
            }
        }
        return false;
    }
    private static  boolean poker(int[] nums){
        // 先找出雀牌
        for (int i = 0;i < 9;i++){
            if (nums[i] >=2 ){
                nums[i]-= 2;
                if (run(nums)){
                    return true;
                }
                nums[i]+=2;
            }
        }
        return  false;
    }

    // 测试合法性
    private static boolean begin(int[] cards){
        int[] nums = new int[9];
        for (int i = 0;i < 9;i++){
            nums[i] = 0;
        }
        for (Integer card : cards) {
            nums[card-1] += 1;
        }

        return  poker(nums);
    }

    private static String example(int[] cards){
        int[] nums = new int[9];
        for (int i = 0;i < 9;i++){
            nums[i] = 0;
        }
        for (Integer card : cards) {
            nums[card-1] += 1;
        }
        // 缺一张牌的处理规则
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9;i++){
            if (nums[i] < 4){
                int[] copy = Arrays.copyOf(nums,9);
                copy[i]+=1;
                if (poker(copy)){
                    System.out.println(i+1);
                    builder.append((i+1)).append(" ");
                }
            }
        }
        if (builder.length() ==0){
            builder.append(0);
        }
        return builder.toString();
    }

    public static void main(String[] args){
//        int[] cars = {1, 1 ,1 ,2, 2, 2, 6, 6, 6, 7, 7, 7, 9, 9};
//        int[] cars2 = {1 ,1 ,1, 1, 2, 2, 3, 3, 5, 6, 7 ,7 ,8 ,9};
//        int[] cars3 = {1 ,1 ,1 ,2 ,2, 2, 3, 3, 3, 5, 6, 7, 7, 9};
//        System.out.println(begin(cars));
//        System.out.println(begin(cars2));
//        System.out.println(begin(cars3));

//        int[] test = {1, 1, 1, 1, 2, 2, 3, 3, 5, 6, 7,7, 8, 9};
//        System.out.println(begin(test));


//        int[] e = {1, 1, 1, 2, 2, 2, 5, 5, 5, 6, 6, 6, 9};
//        System.out.println(example(e));
//
//        int[] e2 = {1, 1, 1, 1 ,2, 2, 3, 3, 5, 6, 7, 8, 9};
//        System.out.println(example(e2));
//
//        int[] e3 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 7, 7, 9};
//        System.out.println(example(e3));

        Scanner scanner = new Scanner(System.in);
        int i = 12;
        int[] input  = new int[13];
        while (i >= 0){
           int value =  scanner.nextInt();
            input[i] = value;
            i--;
        }
        System.out.println(example(input));
    }
}
