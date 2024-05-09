package baekjoon.bronze.b2

fun main() {
    val a = readln().toDouble()
    val (m, n) = readln().split(" ").map { it.toDouble() }
    val result = ArrayList<Double>()

    result.add(m / a * 2)
    result.add(n / a * 2)
    result.add(maxOf(n / a, m))
    result.add(maxOf(m / a, n))
    println(result.minOrNull())
}