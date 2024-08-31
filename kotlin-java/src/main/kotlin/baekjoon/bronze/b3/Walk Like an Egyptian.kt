package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        println("$n => ${n * n - (n - 1)}")
    }
}
