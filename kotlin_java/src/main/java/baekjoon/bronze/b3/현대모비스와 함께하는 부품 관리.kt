package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    readln()
    repeat(n) { readln() }
    println("Material Management ${it + 1}\nClassification ---- End!")
}
