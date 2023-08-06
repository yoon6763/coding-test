package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val str = readln().split(" ")
    println("god" + str.slice(1..str.size - 1).joinToString(""))
}
