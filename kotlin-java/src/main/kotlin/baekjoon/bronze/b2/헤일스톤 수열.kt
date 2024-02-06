package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        var n = readln().toInt()
        var max = n
        while (n != 1) {
            max = maxOf(max, n)
            n = if (n % 2 == 0) n / 2 else n * 3 + 1
        }
        sb.appendLine(max)
    }
    print(sb)
}