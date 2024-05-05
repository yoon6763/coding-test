package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }.sorted()
        sb.append("Case #${it + 1}: ${if (a * a + b * b == c * c) "YES\n" else "NO\n"}")
    }
    print(sb)
}