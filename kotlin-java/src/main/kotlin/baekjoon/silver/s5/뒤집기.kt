package baekjoon.silver.s5

fun main() {
    val line = readln().trim()
    println(minOf(line.split("0").filter { it != "" }.size, line.split("1").filter { it != "" }.size))
}