package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val set = mutableSetOf<String>()
    repeat(readLine().toInt()) {
        set.add(readLine())
    }
    println(set.size)
}