package letcode.dp;

/**
 * 动态规划，听起来很唬人，其实很简单：
 * 1.也是暴力穷举法。
 * 2.优化点就是，对于已经计算过的，进行存储起来，减少重复计算。
 * 3.难点就是状态转移规则。就是如何存储规则和
 */

// 开胃菜，斐波那楔数
// 注意这个典型的示例

class Fib{
    public int fib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if (n >1){
            for (int i = 2; i <=n ;i++){
                dp[i] = dp[i-1] +dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(new Fib().fib(4));

    }
}