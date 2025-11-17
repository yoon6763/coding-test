package baekjoon.bronze.b1

fun main() {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    repeat(readln().toInt()) {
        val (a, b) = readln().trim().split("\\s+".toRegex()).map { it.toInt() }
        println(gcd(a, b))
    }
}

