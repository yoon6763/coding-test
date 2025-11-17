package baekjoon.bronze.b3

fun main() {
    var money = readln().toInt()
    val n = readln().toInt()

    for (i in 1..<n) {
        println(i)
        money -= i
    }

    println(money)
}