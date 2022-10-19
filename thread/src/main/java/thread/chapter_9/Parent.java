package thread.chapter_9;

public class Parent {
    static {
        System.out.println("static 父类 初始化 ");
    }
    {
        System.out.println("子类初始化");
    }
    public Parent(){
        System.out.println("父类构造函数初始化");
    }
}
