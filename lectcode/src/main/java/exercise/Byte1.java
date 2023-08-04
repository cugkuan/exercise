package exercise;


/**
 *  三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 *
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 *
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 *
 */
class Byte1 {


    private static boolean checkSame(StringBuilder text,int i){
        if (text.length() >= 3 && i > 1){
            if (text.charAt(i) == text.charAt(i-1) && text.charAt(i-1) == text.charAt(i-2)){
                text.deleteCharAt(i);
                return true;
            }
        }
        return false;
    }
    private static  boolean checkAABB(StringBuilder text,int i){
        if (text.length() >=4 && i > 2){
            if (text.charAt(i-3) == text.charAt(i-2) && text.charAt(i-1) == text.charAt(i) ){
                text.deleteCharAt(i);
                return true;
            }
        }
        return false;
    }
    private static String exc(String text){
        int j=1;
        StringBuilder builder = new StringBuilder(text);
        while (j < builder.length()){
            if (checkSame(builder,j) || checkAABB(builder,j)){
            }else {
                j++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
//        System.out.println(exc("helloo"));
//        System.out.println(exc("wooooooow"));
        System.out.println(exc("mmccchwwkkkccccooojxbzooeeyyyggxggswwwyyynnuuffsdsmmnuunmmuuvvzzyycctttijjjrrmtttvvckkkllquuyyykkkvvgggllhtw"));

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        List<String> out = new ArrayList<>();
//        while (n > 0){
//             String input =    scanner.next();
//             out.add(exc(input));
//             n--;
//        }
//        for (String o:out){
//            System.out.println(o);
//        }
    }
}