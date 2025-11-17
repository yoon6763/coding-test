package baekjoon.bronze.b3

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    for (i in 0..<x) {
        var flag = i % 2 == 0
        for (j in 0..<y) {
            sb.append(if (flag) "*" else ".")
            flag = !flag
        }
        sb.appendLine()
    }

    print(sb)
}