package baekjoon.bronze.b4

fun main() {
    val r1s = readLine()!!.split(" ")
    val r1 = r1s[0].toInt()
    val s = r1s[1].toInt()

    println(if(r1 > s) s - r1 + s else s - r1 + s)
}