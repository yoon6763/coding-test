package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val line = readLine().lowercase()
        if (line == line.reversed()) {
            println("Yes")
        } else {
            println("No")
        }
    }
}