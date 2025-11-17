package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val n = readln().toInt()
        if ((n * n).toString().endsWith(n.toString())) sb.append("YES\n")
        else sb.append("NO\n")
    }
    print(sb)
}