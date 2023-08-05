package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 毕业旅行，回溯算法，算法没问题，但是运行超时了。需要动态规划
 */
public class Byte3 {
    private static int minCost  = Integer.MAX_VALUE;
    private static  void bt(List<Integer> pick,List<Integer> select,int cost, int[][] city){
        if (select.size() == pick.size()){
            // 回到起点
            int pre = select.get(select.size() -1);
            int c = city[pre][0];
            minCost = Math.min(minCost,cost+c);
            return;
        }
        for (int i = 0;i < pick.size();i++){
            int value = pick.get(i);
            if (!select.contains(value)){
                // 选取目的地
                int pr = select.get(select.size() -1);
                select.add(value);
                int c = city[pr][value] + cost;
                if (c >= minCost){
                    select.remove((Integer) value);
                }else {
                    bt(pick, select, c, city);
                    select.remove((Integer) value);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        minCost = Integer.MAX_VALUE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( reader.readLine());
        int i = 0;

        int[][] city = new int[n][n];
        while (i < n){
            String[] lines = reader.readLine().split(" ");
            for (int j = 0; j < n;j++){
                city[i][j] = Integer.parseInt(lines[j]);
            }
            i++;
        }
        List<Integer> picks = new ArrayList<>();
        for (int z = 0;z < n;z++){
            picks.add(z);
        }
        List<Integer> select = new ArrayList<>();
        select.add(0);
        bt(picks,select,0,city);
        System.out.println(minCost);
    }
}
