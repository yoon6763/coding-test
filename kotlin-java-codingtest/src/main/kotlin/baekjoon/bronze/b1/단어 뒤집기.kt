package baekjoon.bronze.b1

fun main(): Unit = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.reversed() }.forEach {
            print("$it ")
        }
        println()
    }
}