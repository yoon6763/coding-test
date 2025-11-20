package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    println(
        when {
            n == 0 -> 1
            n > 0 -> Integer.toBinaryString(n).length
            else -> 32
        }
    )
}
