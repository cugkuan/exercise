package letcode.backtrack


/**
 *  最基础的回溯算法
 */
fun backTrack(print:String,pickList:List<Int>) {
    if (pickList.isEmpty()){
        println(print)
        return
    }
    pickList.forEach {
        val newPickList = ArrayList<Int>(pickList)
        newPickList.remove(it)
        backTrack(if (print.isEmpty()){"$it"}else{"$print,$it"},newPickList)
    }
}

fun backTrack2(selectedList:MutableList<Int>,pickList:List<Int>) {
    if (pickList.isEmpty()){
        selectedList.forEach {
            print(it)
            print(",")
        }
        println()
        return
    }
    pickList.forEach {
        val newPickList = ArrayList<Int>(pickList)
        newPickList.remove(it)
        // 加入选择列表
        selectedList.add(it)
        backTrack2(selectedList,newPickList)
        // 删除添加选择
        selectedList.remove(it)
    }
}

 fun backTrack3(selectedList:MutableList<Int>,pickList:List<Int>) {
    if (selectedList.size == pickList.size){
        selectedList.forEach {
            print(it)
            print(",")
        }
        println()
        return
    }
    pickList.forEach {
        if (selectedList.contains(it).not()) {
            // 加入选择列表
            selectedList.add(it)
            backTrack3(selectedList, pickList)
            // 删除添加选择
            selectedList.remove(it)
        }
    }
}

fun main(){

    val list = arrayListOf(1,2,3)
    //backTrack("",list)

    backTrack3(ArrayList<Int>(3),list)

}

