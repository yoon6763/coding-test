package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) return
        val numbers = List(n) { readln().split(" ").map { it.toInt() } }.flatten().toSet()
        println(if (numbers.containsAll(List(49) { it + 1 })) "Yes" else "No")
    }
}
