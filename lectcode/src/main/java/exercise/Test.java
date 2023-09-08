package exercise;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n ==0){
            System.out.println(0);
        }else if (n == 1){
            System.out.println(1);
        }else  if (n ==2){
            System.out.println(2);
        }else {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 0);
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[n]);
        }
    }
}


