package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (n, cmd) = readLine().split(" ")
        if (cmd == "C") {
            readLine().split(" ").forEach {
                sb.append((it[0] - 64).toInt()).append(" ")
            }
        } else {
            readLine().split(" ").map { it.toInt() }.forEach {
                sb.append((it + 64).toChar()).append(" ")
            }
        }
        sb.appendLine()
    }
    print(sb)
}