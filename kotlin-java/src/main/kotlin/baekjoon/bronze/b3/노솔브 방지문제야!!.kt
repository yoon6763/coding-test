package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var n = readLine().toDouble()
        var able = 1
        while (n != 1.0) {
            if (n % 2 != 0.0) {
                able = 0
                break
            }
            n /= 2
        }

        sb.appendLine(able)
    }

    print(sb)
}