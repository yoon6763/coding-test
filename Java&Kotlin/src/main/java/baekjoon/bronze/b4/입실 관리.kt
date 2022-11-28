package baekjoon.bronze.b4

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        println(readLine().lowercase())
    }
}