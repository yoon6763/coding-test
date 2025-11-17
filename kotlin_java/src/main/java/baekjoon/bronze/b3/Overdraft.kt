package baekjoon.bronze.b3

fun main() {
    var answer = 0
    var amount = 0
    repeat(readln().toInt()) {
        amount += readln().toInt()
        answer = minOf(answer, amount)
    }
    println(-answer)
}