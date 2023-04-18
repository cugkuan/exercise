package letcode.hash;

/**
 * 异位词，指的是，两个 字符串中，每一个字符出现的次数相同
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 */
public class Anagram {
    /**
     * 解题是非常巧妙的
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s,String t){
        int[] record = new int[26];
        if (s.length() == t.length()){
            for (int i = 0; i < s.length();i++){
                record[s.charAt(i) - 'a']+=1;
                record[t.charAt(i) - 'a']-=1;
            }
            for (int i = 0;i < s.length();i++){
                if (record[i] != 0){
                    return false;
                }
            }
            return true;
        }else {
            return  false;
        }
    }
    public static void main(String[] args){
        Anagram anagram = new Anagram();

        System.out.println(anagram.isAnagram("anagram","nagaram"));
        System.out.println(anagram.isAnagram("rat","car"));
    }
}
