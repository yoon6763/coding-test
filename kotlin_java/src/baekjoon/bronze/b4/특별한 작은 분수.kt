package baekjoon.bronze.b4

fun main() {
    var (x, n) = readln().split(" ").map { it.toInt() }
    for (i in 0..<n) x = (if (x % 2 == 0) (x / 2) xor 6 else (2 * x) xor 6)
    println(x)
}
