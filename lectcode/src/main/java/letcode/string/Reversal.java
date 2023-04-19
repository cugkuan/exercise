package letcode.string;

/**
 * 翻转字符串
 */
public class Reversal {

    public void reversal(char[] s){
        int left  = 0;
        int right = s.length -1;

        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        new Reversal().reversal(s);
        System.out.println(s);
    }
}
