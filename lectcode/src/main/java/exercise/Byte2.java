package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 题目转变成，从 n 个数字中，选出三个，且最大数和最小数之间不能 超过  D
 * 这个是使用回溯算法的一种解答。
 * 回溯算法的时间复杂度太高了，不可取
 */
class Byte2 {

    static int count = 0;
    public static boolean check(int d, List<Integer> select) {
        if (select.size() <= 1) {
            return true;
        } else {
            return Collections.max(select) - Collections.min(select) <= d;
        }
    }
    public static void backTrack(int d,int i,List<Integer> picks, List<Integer> select) {
        if (!check(d,select)){
            return;
        }
        if (select.size() == 3) {
            StringBuilder builder = new StringBuilder();
            select.forEach(integer -> {
                builder.append(integer).append(',');
            });
            System.out.println(builder);
            count ++;
            return;
        }
        if (i >= picks.size()){
            return;
        }
        for (int j = i; j < picks.size();j++){
            int pick =  picks.get(j);
            if (!select.contains(pick)) {
                select.add(pick);
                backTrack(d,j+1,picks, select);
                select.remove((Integer) pick);
            }

        }
    }

    public static void main(String[] args){
        count = 0;
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int d = scanner.nextInt();
        List<Integer> picks = new ArrayList<>();
        while (n > 0){
            int c = scanner.nextInt();
            picks.add(c);
            n--;
        }
        backTrack(d,0,picks,new ArrayList<>());

        System.out.println(count%99997867);

    }


}