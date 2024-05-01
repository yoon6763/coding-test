package baekjoon.bronze.b3

fun main() {
    var aScore = 0
    var bScore = 0
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        when {
            a > b -> aScore += a + b
            a == b -> {
                aScore += a
                bScore += b
            }
            else -> bScore += a + b
        }
    }
    println("$aScore $bScore")
}
