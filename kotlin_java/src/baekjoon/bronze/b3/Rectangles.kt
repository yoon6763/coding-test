package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val (x, y, rect) = readLine().split(" ").map { it.toInt() }
        if (x == 0 && y == 0 && rect == 0) break

        if (rect == 0) sb.appendLine("$x $y ${x * y}")
        else if (x == 0) sb.appendLine("${rect / y} $y $rect")
        else sb.appendLine("$x ${rect / x} $rect")
    }
    print(sb)
}