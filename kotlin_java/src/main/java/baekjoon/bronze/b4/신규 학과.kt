package baekjoon.bronze.b4

fun main() {
    println(generateSequence { readln() }.drop(1).map { it.split(" ") }.first { it[1] == "2026" }[0])
}