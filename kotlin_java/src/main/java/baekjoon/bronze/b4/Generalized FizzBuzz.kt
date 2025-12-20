package baekjoon.bronze.b4

fun main() {
    fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    fun lcm(a: Long, b: Long): Long {
        return a / gcd(a, b) * b
    }

    val (n, a, b) = readln().split(" ").map { it.toLong() }
    val fizzBuzz = n / lcm(a, b)
    println("${n / a - fizzBuzz} ${n / b - fizzBuzz} $fizzBuzz")
}
