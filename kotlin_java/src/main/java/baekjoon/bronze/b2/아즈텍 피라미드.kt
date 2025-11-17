package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var a = 1
    var b = 1
    var floor = 1

    while (true) {
        b += 4 * floor
        a += b
        if (a > n) break
        floor++
    }
    println(floor)
}
