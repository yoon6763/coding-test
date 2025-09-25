package baekjoon.bronze.b2

fun main() {
    fun gcd(a: Int, b: Int): Triple<Int, Int, Int> {
        if (b == 0) return Triple(a, 1, 0)
        val (g, x1, y1) = gcd(b, a % b)
        val x = y1
        val y = x1 - (a / b) * y1
        return Triple(g, x, y)
    }

    val (a, m) = readln().trim().split("\\s+".toRegex()).map { it.toInt() }
    val (g, x, _) = gcd(a, m)
    var inv = x % m
    if (inv <= 0) inv += m
    println(inv)
}
