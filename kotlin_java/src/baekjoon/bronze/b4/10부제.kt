package baekjoon.bronze.b4

fun main() {
    val day = readLine()!!.toInt()
    val car = readLine()!!.split(" ").map { it.toInt() }
    var cnt = 0
    car.forEach { if(day == it) cnt++ }
    println(cnt)
}