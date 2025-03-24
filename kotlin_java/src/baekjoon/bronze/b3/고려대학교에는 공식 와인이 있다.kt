package baekjoon.bronze.b3

fun main() {
    val (c, k, p) = readln().split(" ").map { it.toInt() }
    var sum = 0
    for (i in 1..c) sum += k * i + p * i * i
    print(sum)
}
