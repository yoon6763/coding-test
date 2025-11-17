package baekjoon.bronze.b4

fun main() {
    val line = readln()
    println(line.length + line.count { it == ':' } + line.count { it == '_' } * 5)
}