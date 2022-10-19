package thread.chapter_9;

public class Single {

    // 这行代码移动 到 x,y 的下方，输出的结果还不一样
    private static Single single = new Single();
    private static int x = 0;
    private static int y ;



    private Single(){
        x++;
        y++;
    }

    public static void main(String[] args){
        Single singel = Single.single;
        System.out.println(singel.x);
        System.out.println(singel.y);
    }
}
