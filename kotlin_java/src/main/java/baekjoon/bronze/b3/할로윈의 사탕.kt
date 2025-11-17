package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (candy, child) = readLine().split(" ").map { it.toInt() }
        sb.append("You get ${candy / child} piece(s) and your dad gets ${candy % child} piece(s).\n")
    }
    print(sb)
}