package letcode.dp;

/**
 * https://leetcode.cn/problems/coin-change/
 *
 * amount 是整数，k的面值也是整数
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 */
class CoinChange {
    /**
     * 实际上也是穷举法
     *
     * 设 f(x) 为金额为 x 的最小值
     *
     * 对于 x; 上一个凑成 x金额为:  x - ck;此时，要么能凑出 就是 f(x) = f(x-ck) +1；要么凑不出；f(x) = f(x-ck)
     *
     *
     */
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount;i++){
            dp[i] = -1;
        }
        return dp(dp,coins,amount);
    }

    private int dp(int[] dp,int[] coins,int amount){
        if (amount == 0) return 0;
        if (amount < 0) return  -1;
        if (dp[amount] != -1){
            return  dp[amount];
        }else {
            int result  = Integer.MAX_VALUE;
            for (int i = 0;i < coins.length;i++){
                int value = dp(dp,coins,amount - coins[i]);
                if (value == -1){
                    continue;
                }
                result = Math.min(result,value +1);
            }
            dp[amount] = result == Integer.MAX_VALUE? -1:result;
            return dp[amount];
        }
    }
    public static void main(String[] args){

        int[] coins = {1,2,5};
        int result = new CoinChange().coinChange(coins,11);
        System.out.println(result);
    }
}