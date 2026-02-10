package baekjoon.bronze.b3


fun main() {
    val (a, b) = readln().split(" ")

    fun calc(s: String): Int = s.length * s.sumOf { it - '0' }

    val aa = calc(a)
    val bb = calc(b)

    println(
        when {
            aa > bb -> 1
            aa < bb -> 2
            else -> 0
        }
    )
}
