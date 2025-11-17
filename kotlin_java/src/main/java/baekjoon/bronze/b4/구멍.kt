package baekjoon.bronze.b4

fun main() {
    val s = readln()
    println(s.count { it == 'B' } * 2 + s.count{ it in "AabDdegOoPpQqR@"})
}