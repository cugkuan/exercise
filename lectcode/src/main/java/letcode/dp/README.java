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
    private int n;
    private int[] dp;
    public Fib(int n){
        this.n = n;
        this.dp = new int[n+1];
        for (int i = 0; i <=n ;i++){
            dp[i] = 0;
        }
    }
    public int exc(){
        return fib(n);
    }
    private int fib(int  i){
        if (i == 0 || i == 1) {
            dp[i] = i;
            return i;
        }else {
            if (dp[i] != 0){
                return dp[i];
            }else {
                return fib(i-1) + fib(i-2);
            }
        }
    }

    public static void main(String[] args){
        int value = new Fib(4).exc();
        System.out.println(value);

    }
}