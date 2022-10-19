package thread.chapter_16

class FlightSecurity(){

    var count: Int = 0
    var boardingPass: String = "null"
    var idCard: String = "null"

    // 对 pass 增加 syn 修饰，可以避免问题
    fun pass( boardingPass: String,idCard: String){
        this.idCard = idCard
        this.boardingPass = boardingPass
        count++
        check()
    }

    private fun check(){
        if (boardingPass[0] !=  idCard[0]){
            throw  java.lang.RuntimeException("---->${toString()}")
        }
    }

    override fun toString(): String {
        return "count=$count; boardingpass:$boardingPass  idCard:$idCard"
    }
}


class Passenger(val flightSecurity: FlightSecurity,val boardingPass: String,val idCard: String) : Thread() {

    override fun run() {
        super.run()
        while (true){
            flightSecurity.pass(boardingPass,idCard)
        }
    }
}


fun main(){

    val flightSecurity = FlightSecurity()

    Passenger(flightSecurity,"A123456","AF1223").start()
    Passenger(flightSecurity,"B123456","BF1223").start()
    Passenger(flightSecurity,"C123456","CF1223").start()
    Passenger(flightSecurity,"D123456","DF1223").start()
    Passenger(flightSecurity,"E123456","EF1223").start()
    Passenger(flightSecurity,"F123456","FF1223").start()
    Passenger(flightSecurity,"G123456","GF1223").start()
}