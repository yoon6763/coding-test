package baekjoon.bronze.b4

fun main() {
    val (vk, jk) = readln().split(" ").map { it.toLong() }
    val (va, ja) = readln().split(" ").map { it.toLong() }
    val (vh, dh, jh) = readln().split(" ").map { it.toLong() }
    println(vh * dh * jh * (va * ja + vk * jk))
}