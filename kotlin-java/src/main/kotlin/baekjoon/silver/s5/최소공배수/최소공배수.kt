package baekjoon.silver.s5.최소공배수

fun main() {
    val (a, b) = readln().split(" ").map(String::toLong)
    println(lcm(a, b))
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)