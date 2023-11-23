package baekjoon.silver.s5

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        println(lcm(a, b))
    }
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)