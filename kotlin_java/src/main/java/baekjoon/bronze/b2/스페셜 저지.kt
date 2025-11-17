package baekjoon.bronze.b2

fun main() {
    val a = readln()
    val b = readln()
    val c = readln()
    println(if (c in a && c in b) "YES" else "NO")
}
