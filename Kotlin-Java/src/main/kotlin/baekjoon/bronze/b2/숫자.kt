package baekjoon.bronze.b2

fun main() {
    val num = readln().split(" ").map { it.toLong() }
    val n = num.min()
    val m = num.max()

    if (m - n <= 1) {
        println(0)
    } else {
        println(m - n - 1)
        for (i in n + 1 until m) print("$i ")
    }
}