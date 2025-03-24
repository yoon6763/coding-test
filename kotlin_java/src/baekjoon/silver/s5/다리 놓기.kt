package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        var result = 1L

        for (i in 1 .. n) result = result * (m - i + 1) / i

        sb.append(result).append("\n")
    }
    print(sb)
}