package baekjoon.bronze.b5

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    println(readLine().count { it in arrayOf('a', 'e', 'i', 'o', 'u') })
}