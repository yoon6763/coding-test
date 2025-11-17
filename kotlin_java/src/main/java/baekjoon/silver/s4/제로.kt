package baekjoon.silver.s4

fun main() {
    val case = readLine()!!.toInt()

    var array = ArrayList<Int>()

    for(i in 0 until case) {
        val read = readLine()!!.toInt()
        if(read == 0){
            array.removeLast()
        } else {
            array.add(read)
        }
    }
    print(array.sum())
}