package baekjoon.bronze.b3

fun main() {
    val t = readln().toInt()
    readln()
    val f = readln().split(" ").sumOf { it.toInt() }
    println(if(f >= t) "Padaeng_i Happy" else "Padaeng_i Cry")
}