package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var result = 0
    var left = 1

    repeat(readLine().toInt()) {
        val right = left + m - 1
        val fallPos = readLine().toInt()
        if (fallPos in left..right) return@repeat
        if (left > fallPos) {
            result += left - fallPos
            left = fallPos
        } else if (left < fallPos) {
            result += fallPos - right
            left += fallPos - right
        }
    }
    println(result)
}