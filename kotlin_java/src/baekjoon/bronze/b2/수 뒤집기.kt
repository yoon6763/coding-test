package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    var line = readln()
    line = (line.toInt() + line.reversed().toInt()).toString()
    println(if (line == line.reversed()) "YES" else "NO")
}