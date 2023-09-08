

class  A{

    var i = run {
        println("属性初始化")
        1
    }
    constructor(){
        println("构造函数初始化")
    }
    init {
        println("init代码初始化")
    }
}

fun main(){

    val a = A();
    a.i


}