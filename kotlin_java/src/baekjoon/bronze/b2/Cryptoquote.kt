package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val input = readln()
    val parse = readln().toCharArray()
    println(input.map { if (it == ' ') ' ' else parse[it - 'A'] }.joinToString(""))
}