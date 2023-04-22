package letcode.string;

import letcode.UtilsKt;

public class KMP {
    public int forceMatch(String s,String  p){
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()){
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else {
                // 回退
                i = i - j +1;
                j = 0;
            }
        }
        if (j == p.length()){
            return i- j;
        }else {
            return -1;
        }
    }
    // kmp 算法的一种比较 原始的实现，next 数组表示前后缀共有的最大长度
    // 核心的处理 是 p 指针的 回退逻辑
    public int kmp(String s,String p){
        int i = 0;
        int j = 0;
        int[] next = getNext(p);
        while (i < s.length() && j < p.length()){
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else {
                if (j > 0){
                    j = next[ j-1];
                }else {
                    i++;
                }
            }
        }
        if (j == p.length()){
            return i-p.length();
        }else {
            return  -1;
        }
    }

    /**
     * next 数组的求解，这个需要进行理解。
     * @param p
     * @return
     */
    public int[] getNext( String p){
        int[] next = new int[p.length()];
        int j = 0;
        for (int i = 1;i < p.length();i++){
            if (p.charAt(i) == p.charAt(j)){
                j++;
            }else {
                j= 0;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args){
        KMP kmp = new KMP();
        String S = "BBC ABCDAB ABCDABCDABDE";
        String P = "ABCDABD";
        // 结果是 15;
       // System.out.println(kmp.forceMatch(S,P));
        System.out.println(kmp.kmp(S,P));

     //   UtilsKt.count(kmp.getNext(P));

    }


}
