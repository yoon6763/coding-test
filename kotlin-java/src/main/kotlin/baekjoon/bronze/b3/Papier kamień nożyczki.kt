package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val adam = readln().split(" ").map { it.toDouble() }.toDoubleArray()
    val gosia = readln().split(" ").map { it.toDouble() }.toDoubleArray()
    val a = adam[0] * gosia[1] + adam[1] * gosia[2] + adam[2] * gosia[0]
    val g = gosia[0] * adam[1] + gosia[1] * adam[2] + gosia[2] * adam[0]
    println(
        when {
            a > g -> "ADAM"
            a < g -> "GOSIA"
            else -> "="
        }
    )
}