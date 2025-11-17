package baekjoon.bronze.b2

fun main() {
    val s = readln().toCharArray()
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        s[a] = s[b].also { s[b] = s[a] }
    }

    println(s.joinToString(""))
}