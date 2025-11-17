package baekjoon.bronze.b3

fun main() {
    var (a, b, c) = readln().split(" ").map { it.toInt() }
    var day = 0
    var money = 0
    while (money < c) {
        day++
        money += a
        if (day % 7 == 0) money += b
    }
    println(day)
}