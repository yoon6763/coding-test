package baekjoon.bronze.b4

fun main() {
    val line = readLine()!!.split("/").map { it.toInt() }
    if(line[1] == 0 || line[0] + line[2] < line[1]) println("hasu") else println("gosu")
}