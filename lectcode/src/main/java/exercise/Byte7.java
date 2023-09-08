package exercise;


import java.util.Scanner;

/**

 *设置 H（i）为第 i个建筑的能量值。
 * E（i）为 第 i 个建筑 的剩余能量；
 * 于是，E（i+1） = 2E(i) - H(i+1)
 * 于是 有  E(i) = ( H(i+1) + E(i+1))/2
 * 我们从从后面往前面推。理想的情况下，最后跳完后 能量为 0 于是 往前面倒推
 * 这个题就是典型的贪心算法，从局部最优推倒道全局最优
 */
public class Byte7 {

    public static int e(int[] h){
        int e = 0;
        for (int i = h.length-1;i >= 0;i--){
            e =  (int)Math.ceil((h[i] + e)/2f);
        }
        return e;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        int i = 0;
        while (i <n){
            h[i] = scanner.nextInt();
            i++;
        }
        System.out.println(e(h));
    }
}
