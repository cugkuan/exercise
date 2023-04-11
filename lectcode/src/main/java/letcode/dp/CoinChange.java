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
     * 设 f(x) 为金额为 x ;至少需要 f(x)枚硬币
     *
     * 于是,当能凑出金额时：
     * f(x) =  f(x -coin[i))+ 1
     *
     *
     */
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i <= amount ;i++){
            for (int j = 0;j < coins.length;j++){
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] +1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){

        int[] coins = {1,2,5};
        int result = new CoinChange().coinChange(coins,11);
        // 3
        System.out.println(result);
    }
}