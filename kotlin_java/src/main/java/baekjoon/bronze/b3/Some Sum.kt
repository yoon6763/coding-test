package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    println(
        if (n % 4 == 0) "Even"
        else if (n % 2 == 0) "Odd"
        else "Either"
    )
}