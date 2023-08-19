package baekjoon.silver.s4

fun main() {
    var line = readln()
    val keywords = Array(readln().toInt()) { readln() }

    while (!keywords.any { it in line }) {
        line = line.toCharArray().map { if (it == 'z') 'a' else it + 1 }.joinToString("")
    }

    println(line)
}