package letcode.dp;

/**
 * 背包问题
 * 给你一个可装载重量为 W 的背包和 N 个物品，
 * 每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * 0-1 背包 和完全背包的处理方式不一样
 */
public class Bag {

    /**
     * 定义 f(n，m) 为 前n个物品，当前背包重量为m 的最大价值
     * 对于 第 n个物品，可以选择放入，也可以选择不能放入，如果能放入则 有  f(n,m) =  f(n-1,m - wt[n]) +val[i] 不能放入 则有 f(n.m) = f(n-1,m)
     * @param w
     */
    public int bag(int w,int[] wt,int[] val){
        int n = wt.length;
        int[][] dp = new int[n+1][w +1];
        for (int i = 0;i<= n ;i++ ){
            dp[i][0] = 0;
        }
        for (int i = 1;i <= n;i++){
            int weight = wt[i-1];
            for (int j = 1 ;j <= w;j++){
                if (j - weight >= 0){
                   dp[i][j] = Math.max(dp[i-1][j-weight] + val[i-1],dp[i-1][j]);
                }else {
                   dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[n][w];
    }

    /**
     * 这种方法错误的是因为，物品不能重复使用，已经使用过了就不能再用了，不是无限的。
     *
     * @param w
     * @param wt
     * @param val
     * @return
     */
    public int bag2(int w,int[] wt,int[] val){
        int n = wt.length;
        // 重量 dp[
        int dp[] = new int[w+1];
        for (int i = 0;i<=w ;i++){
            dp[i] = 0;
        }
        for (int i = 0;i <=w;i++){
            int value = 0;
            for (int j = 0; j< n;j++ ){
                // 能够放入
                int c = i- wt[j];
                if (c >= 0){
                    value = Math.max(value,dp[c] + val[j]);
                }
            }
            dp[i] = value;
        }
        return dp[w];
    }

    public static void main(String[] args){

        //N = 3, W = 4
        //wt = [2, 1, 3]
        //val = [4, 2, 3]

        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        // 输出的结果为 6
        System.out.println(new Bag().bag(4,wt,val));
        System.out.println(new Bag().bag2(4,wt,val));
    }
}
