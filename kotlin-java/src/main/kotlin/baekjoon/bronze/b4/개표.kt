package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        var n = readln().toInt()
        while (n >= 5) {
            n -= 5
            sb.append("++++ ")
        }
        sb.appendLine("|".repeat(n))
    }
    print(sb)
}