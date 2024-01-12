package baekjoon.bronze.b4

fun main() {
    var sum = 0
    repeat(readln().toInt()) {
        sum += when (readln().split(" ")[0].toInt()) {
            136 -> 1000
            142 -> 5000
            148 -> 10000
            154 -> 50000
            else -> 0
        }
    }
    println(sum)
}