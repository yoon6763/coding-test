package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine() }
    val length = arr[0].length
    var k = 1

    while (true) {
        val map = arr.map { it.substring(length - k) }.toSet()
        if (map.size == n) {
            println(k)
            break
        }

        k++
    }
}