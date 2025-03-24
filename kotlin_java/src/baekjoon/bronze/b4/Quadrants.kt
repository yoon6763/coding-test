package baekjoon.bronze.b4

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val (x1, x2) = readLine().trim().split(" ").map { it.toDouble() }
        if (x1 == 0.0 && x2 == 0.0) {
            sb.appendLine("AXIS")
            break
        }
        if (x1 == 0.0 || x2 == 0.0) {
            sb.appendLine("AXIS")
            continue
        }
        sb.append('Q').appendLine(if (x1 > 0) if (x2 > 0) 1 else 4 else if (x2 > 0) 2 else 3)
    }

    print(sb)
}