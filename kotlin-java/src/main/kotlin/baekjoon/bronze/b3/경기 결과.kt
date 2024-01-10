package baekjoon.bronze.b3

fun main() {
    var (a, b) = 0 to 0
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        when {
            x > y -> a++
            x < y -> b++
        }
    }

    println("$a $b")
}