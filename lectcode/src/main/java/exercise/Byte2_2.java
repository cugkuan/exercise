package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 其实想一下，输入的数字是一个已经被排序好的，那么，确定一个数字后，就能在满足最长距离的另一个数字也能确定。那么问题就解决了。
 * 实际上退化成一个二分查找问题了
 * 5 9  / 1 10 20 30 50
 */
class Byte2_2 {
    private static int binarySearch(int key,int left,int right,List<Integer> nums){
        while (left < right){
            int middle = left + (right - left)/2;
            if (key == nums.get(middle)){
                return middle;
            }else  if (nums.get(middle) > key){
                right = middle-1;
            }else {
                left = middle +1;
            }
        }
        if (nums.get(left) <= key){
            return  left;
        }
        return -1;
    }
    private static int exe(int d, List<Integer> nums) {
        int count = 0;
        for (int i = 0; i < nums.size() -2; i++){
            int key = nums.get(i) + d;
            int end = binarySearch(key,i,nums.size()-1,nums);
            int num = end  - i  ;
            if (num > 2 ){
                count += (num*(num -1)/2);
            }else if (num ==2){
                count += 1;
            }
        }
        return count % 99997867;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        List<Integer> picks = new ArrayList<>();
        while (n > 0) {
            int c = scanner.nextInt();
            picks.add(c);
            n--;
        }
        System.out.println(exe(d, picks));
    }
}