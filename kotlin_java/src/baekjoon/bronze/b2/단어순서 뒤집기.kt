package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) { sb.append("Case #${it+1}: ").append(readln().split(" ").reversed().joinToString(" ")).append("\n") }
    print(sb)
}