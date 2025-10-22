package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    repeat(n) {
        println(fibonacci(readln().toInt()))
    }
}

tailrec fun fibonacci(n: Int, a: Long = 1, b: Long = 1, count: Int = 0): Long {
    return if (count == n) a
    else fibonacci(n, b, a + b, count + 1)
}