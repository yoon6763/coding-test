package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val s = readln()

    val half = n / 2
    val l = s.substring(0, half)
    val r = s.substring(half)

    if (l == r) {
        println("Yes")
    } else {
        println("No")
    }
}