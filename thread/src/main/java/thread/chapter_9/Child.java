package thread.chapter_9;

public class Child extends Parent{
    static {
        System.out.println("static 子类初始化");
    }
    {
        System.out.println("子类初始化");
    }
    public Child(){
        System.out.println("子类构造函数初始化");
    }

}
