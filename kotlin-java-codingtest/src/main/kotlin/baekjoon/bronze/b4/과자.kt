package baekjoon.bronze.b4

fun main() {
    val line = readLine()!!.split(" ").map { it.toInt() }
    println(if(line[0] * line[1] <= line[2]) 0 else line[0] * line[1] - line[2])
}