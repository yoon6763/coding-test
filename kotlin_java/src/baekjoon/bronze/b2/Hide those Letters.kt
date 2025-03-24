package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    for (case in 1..99999999) {
        val (a, b) = readLine().split(" ")
        if (a == "#" && b == "#") break

        sb.appendLine("Case $case")
        repeat(readLine().toInt()) {
            sb.appendLine(readLine().replace(a, "_").replace(b, "_").replace(a.uppercase(), "_").replace(b.uppercase(), "_"))
        }
        sb.appendLine()
    }
    print(sb)
}