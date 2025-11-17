package baekjoon.bronze.b2

fun main() {
    val parse = mapOf(' ' to "%20", '!' to "%21", '$' to "%24", '%' to "%25", '(' to "%28", ')' to "%29", '*' to "%2a")
    while (true) println(readln().apply { if (this == "#") return }.map { parse[it] ?: it }.joinToString(""))
}