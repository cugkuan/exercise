package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 第一行包含一个正整数N，代表测试用例的个数。
 *
 * 每个测试用例的第一行包含一个正整数M，代表视频的帧数。
 *
 * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
 * 所有用例的输入特征总数和<100000
 *
 * N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
 * 特征取值均为非负整数。
 * 输出描述：
 * 对每一个测试用例，输出特征运动的长度作为一行
 * 示例1
 * 输入例子：
 * 1
 * 8
 * 2 1 1 2 2
 * 2 1 1 1 4
 * 2 1 1 2 2
 * 2 2 2 1 4
 * 0
 * 0
 * 1 1 1
 * 1 1 1
 * 输出例子：
 * 3
 * 例子说明：
 * 特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3
 */
// 这道题真的很简单，和上道题有类似的，运用hash相关的知识点。
public class Byte5 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> pre =  new HashMap<>();;
        HashMap<String,Integer> current = new HashMap<>();;
        int max = 0;
        int n = Integer.parseInt(reader.readLine());
        while (n > 0) {
            int m = Integer.parseInt(reader.readLine());
            while (m > 0) {
                String line = reader.readLine();
                String[] result = line.split(" ");
                int frame = Integer.parseInt(result[0]);
                if (frame == 0) {
                    current.clear();
                    pre.clear();
                } else {
                    HashMap<String,Integer> temp = pre;
                    pre = current;
                    current = temp;
                    current.clear();
                    for (int i = 1; i < result.length; i++) {
                        if (i % 2 == 0) {
                            String key = result[i] + result[i - 1];
                            Integer value = pre.get(key);
                            if (value == null){
                                current.put(key,1);
                                max = Math.max(max,1);
                            }else {
                                int newValue = value +1;
                                current.put(key,newValue);
                                max = Math.max(max,newValue);
                            }
                        }
                    }
                }
                m--;
            }
            n--;
        }
        System.out.println(max);
    }
}
