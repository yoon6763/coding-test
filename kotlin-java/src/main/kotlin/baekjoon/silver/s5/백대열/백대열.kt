package baekjoon.silver.s5.백대열

fun main() {
    val (n, m) = readln().split(":").map(String::toInt)
    val gcd = gcd(n, m)
    println("${n / gcd}:${m / gcd}")
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)