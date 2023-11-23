package baekjoon.bronze.b3

fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        val nm = readLine()!!.split(",")
        println(nm[0].toInt() + nm[1].toInt())
    }
}