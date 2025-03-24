package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val arr = readLine().split(" ").map { it.toInt() }.filter { it % 2 == 0 }
        sb.append("${arr.sum()} ${arr.minOrNull()}\n")
    }
    print(sb)
}