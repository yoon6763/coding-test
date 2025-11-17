package baekjoon.bronze.b2

fun main() {
    var sum = 5L
    for (i in 2..readln().toInt()) sum += (i * 3 + 1)
    println(sum % 45678)
}