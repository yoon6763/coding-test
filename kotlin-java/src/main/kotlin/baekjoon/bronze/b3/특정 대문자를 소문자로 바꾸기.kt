package baekjoon.bronze.b3

fun main() {
    var s = readln()
    readln().split(" ").forEach { s = s.replace(it, it.lowercase()) }
    println(s)
}