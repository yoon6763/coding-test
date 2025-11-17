package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(10) { readLine().toInt() }

    // 최빈값
    val mode = arr.groupingBy { it }.eachCount().maxByOrNull { it.value }!!.key
    // 평균
    val avg = arr.average().toInt()
    println(avg)
    println(mode)
}