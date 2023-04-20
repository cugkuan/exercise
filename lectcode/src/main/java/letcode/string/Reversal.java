package letcode.string;

/**
 * 翻转字符串
 * 翻转单词
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

    /**
     * 先去掉空格，
     * 整理的翻转
     * 单词再进行翻转
     * @param input
     * @return
     */
    public String  reversalString(String input){
        System.out.println(input);
        // 清除多余的空格
        StringBuilder sp = removeSpace(input);
        // 全部翻转
        reversalAll(sp);
        // 翻转每一个单词
        int i = 0;
        int j = 0;
        while (j < sp.length()){
            if ( sp.charAt(j)  == ' '){
                reversalWord(sp,i,j-1);
                j++;
                i = j;
            }else {
                j ++;
            }
        }
        // 翻转最后一个单词
        reversalWord(sp,i,sp.length()-1);
        return  sp.toString();
    }
    private StringBuilder removeSpace(String input){
        int start = 0;
        int end = input.length() -1;
        while (input.charAt(start) == ' '){
            start++;
        }
        while (input.charAt(end) == ' '){
            end --;
        }
        StringBuilder sb = new StringBuilder();
        while (start <=end){
            char c = input.charAt(start);
            if (c != ' '  || input.charAt(sb.length() -1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 全部翻转一次
     * @param input
     * @return
     */
    private void reversalAll(StringBuilder input){
        int i =  0;
        int j = input.length() -1;
        while ( i < j){
            char tem = input.charAt(i);
            input.setCharAt(i,input.charAt(j));
            input.setCharAt(j,tem);
            i++;
            j--;
        }
    }
    private void reversalWord(StringBuilder input,int left,int right){
        while ( left < right){
            char tem = input.charAt(left);
            input.setCharAt(left,input.charAt(right));
            input.setCharAt(right,tem);
            left++;
            right--;
        }
    }


    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        Reversal reversal = new Reversal();
        reversal.reversal(s);
        System.out.println(s);
        // 翻转单词
        String result  = reversal.reversalString("  hello world!  ");
        System.out.println(result);
    }
}
