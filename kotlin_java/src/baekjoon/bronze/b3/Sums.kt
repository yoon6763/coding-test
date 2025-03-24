package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val sum1 = n * (n + 1) / 2
        val sum2 = n * n
        val sum3 = n * (n + 1)
        println("$sum1 $sum2 $sum3")
    }
}
