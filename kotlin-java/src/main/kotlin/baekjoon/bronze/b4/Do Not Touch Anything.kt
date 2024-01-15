package baekjoon.bronze.b4

fun main() {
    val (r, c, n) = readln().split(" ").map { it.toInt() }
    val x = if (r % n > 0) (r / n + 1).toLong()
    else (r / n).toLong()
    val y = if (c % n > 0) (c / n + 1).toLong()
    else (c / n).toLong()
    println(x * y)
}
