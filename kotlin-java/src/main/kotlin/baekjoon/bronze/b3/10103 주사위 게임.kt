package baekjoon.bronze.b3

fun main() {
    var (a, b) = 100 to 100
    repeat(readln().toInt()) {
        val (a1, b1) = readln().split(" ").map { it.toInt() }
        when {
            a1 > b1 -> b -= a1
            a1 < b1 -> a -= b1
        }
    }
    println(a)
    println(b)
}