package baekjoon.bronze.b4

fun main() {
    val money = readln().split(" ").map { it.toInt() }.sum()
    val chicken = readln().toInt() * 2

    if(money >= chicken) println(money - chicken) else println(money)
}