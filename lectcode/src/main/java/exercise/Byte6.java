package exercise;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为 N
 * N(0<N≤1024)的商品，请问最少他会收到多少硬币？
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 32M，其他语言64M
 * 输入描述：
 * 一行，包含一个数N。
 * 输出描述：
 * 一行，包含一个数，表示最少收到的硬币数。
 * 示例1
 * 输入例子：
 * 200
 * 输出例子：
 * 17
 * 例子说明：
 * 花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 *
 *    /**
 *      * 设 f(x) 表示金额为 x 的最小组合数
 *      * coin[i] 表示第 i种硬币的金额
 *      * 于是，对于 金额x ,其最小的组合数是
 *      * 于 f(x) = min( f(x-coin[i) + f(coin[i]))
 *      * @param amount
 *      * @param dp
 *      */
public class Byte6 {
    public static int dp(int amount,int[] coin){
        if (amount == 0){
            return 0;
        }
        int[] dp =  new int[amount+1];
        int max = 1024;
        Arrays.fill(dp, max);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1;i <= amount;i++){
            for (int k : coin) {
                if (i - k >= 0) {
                    if (i - k == 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - k] + dp[k]);
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(dp(1024- n,new int[]{1,4,16,64}));
    }
}
