package baekjoon.bronze.b4

fun main() {
    val (n, a, b, c, d) = readln().split(" ").map { it.toInt() }
    val t1 = n / a + if (n % a != 0) 1 else 0
    val t2 = n / c + if (n % c != 0) 1 else 0
    println(if (t1 * b > t2 * d) t2 * d else t1 * b)
}
