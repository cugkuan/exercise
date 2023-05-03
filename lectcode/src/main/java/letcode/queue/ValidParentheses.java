package letcode.queue;

import java.util.Stack;

/**
 * 有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 这个题目地栈的使用非常的典型
 */
public class ValidParentheses {

    private void check(Stack<Character> stack, char c) {
        char m = stack.peek();
        if (m == c) {
            stack.pop();
        }
    }

    /**
     * 这种的时间复杂度比较高；实际上，有些不必要全对比；这种是常规思维
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 入栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')': {
                    check(stack, '(');
                    break;
                }
                case '}': {
                    check(stack, '{');
                    break;
                }
                case ']': {
                    check(stack, '[');
                    break;
                }
                default: {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        // 入栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '[') {
                stack.push(']');
            }else if (stack.isEmpty() || stack.peek() != c){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();


    }

    public static void main(String[] args) {

        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()")); //true
        System.out.println(v.isValid("()[]{}"));//true
        System.out.println(v.isValid("(]"));//false
        System.out.println(v.isValid("([)]"));//false
        System.out.println(v.isValid("{[]}"));//true

    }
}
