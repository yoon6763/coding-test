package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val t = readLine().toInt()
    repeat(t) {
        when (val n = readLine().toInt()) {
            1 -> sb.append("#")
            2 -> sb.append("##\n##")
            else -> {
                sb.appendLine("#".repeat(n))
                repeat(n - 2) { sb.append("#").append("J".repeat(n - 2)).appendLine("#") }
                sb.append("#".repeat(n))
            }
        }

        if (it != t - 1) sb.appendLine().appendLine()
    }
    print(sb)
}