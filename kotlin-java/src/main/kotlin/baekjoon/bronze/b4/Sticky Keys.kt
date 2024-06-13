package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()
    readln().forEach {
        if (sb.isEmpty() || sb.last() != it) sb.append(it)
    }
    println(sb)
}