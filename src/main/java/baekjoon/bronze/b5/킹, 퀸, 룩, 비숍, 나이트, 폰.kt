package baekjoon.bronze.b5

fun main() {
    val line = readLine()!!.split(" ").map { it.toInt() }
    val arr = arrayOf(1, 1, 2, 2, 2, 8)
    repeat(6) {
        print("${arr[it] - line[it]} ")
    }
}