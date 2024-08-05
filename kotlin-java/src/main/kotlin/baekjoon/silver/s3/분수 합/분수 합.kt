package baekjoon.silver.s3.`분수 합`

fun GCD(a: Int, b: Int): Int {
    if (a % b == 0) return b
    return GCD(b, a % b)
}

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    var top = a * d + b * c
    var bottom = b * d
    val gcd = GCD(top, bottom)
    top /= gcd
    bottom /= gcd
    println("$top $bottom")
}
