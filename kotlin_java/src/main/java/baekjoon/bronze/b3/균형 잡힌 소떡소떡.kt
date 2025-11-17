package baekjoon.bronze.b3

fun main() {
    readln()
    val s = readln().toMutableList()
    val check = { s.filter { it == 's' }.size != s.filter { it == 't' }.size }
    while (check()) s.removeFirst()
    println(s.joinToString(""))
}