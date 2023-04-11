package letcode.dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

假设每一种面额的硬币有无限个.

题目数据保证结果符合 32 位带符号整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CoinChange2 {

    /**
     *
     *  f(x) 表示金额为 x 时的组合数
     *
     * coins[i] 表示 第i种硬币的金额；
     *
     * 于是：当能组合的时候：
     *  f(x) = f(x - coin[i) + f(coin[i])
     *  不能组合时: f(x) = f(x-coin[i)
     *
     */
    public int change(int amount,int[] coins){
        int[] dp = new int[amount +1];
        for (int i = 0;i <  dp.length;i++){
            dp[i] = 0;
        }
        dp[0] = 1;
        for (int i = 0;i <= amount ;i++){
            for (int j = 0; j < coins.length;j++){
                // 表示能进行组合
                if (i - coins[j] >= 0){
                    if (i - coins[j] ==0 && dp [i- coins[j]] == 0){
                        dp[i]  = dp[i]+1;
                    }else {
                        dp[i] += dp[i - coins[j]];
                    }
                }
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        System.out.println(new CoinChange2().change(5,new int[]{1,2,5}));
        System.out.println(new CoinChange2().change(3,new int[]{2}));
        System.out.println(new CoinChange2().change(10,new int[]{10}));
    }

}
