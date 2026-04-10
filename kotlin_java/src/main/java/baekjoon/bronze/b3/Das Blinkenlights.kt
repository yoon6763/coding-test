package baekjoon.bronze.b3

fun main() {
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
    val (p, q, s) = readln().split(" ").map { it.toInt() }
    val lcm = p / gcd(p, q) * q
    if (lcm <= s) println("yes")
    else println("no")
}