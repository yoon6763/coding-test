package baekjoon.bronze.b2

fun main() {
    val cards = IntArray(20) { it + 1 }
    repeat(10) {
        val (start, end) = readln().split(" ").map { it.toInt() - 1 }
        for (i in start..(start + end) / 2) {
            val temp = cards[i]
            cards[i] = cards[end - i + start]
            cards[end - i + start] = temp
        }
    }
    println(cards.joinToString(" "))
}