package baekjoon.bronze.b2

fun main() {
    val words = readLine()!!.split(" ")
    val target = readLine()!!
    println(words.count { it.startsWith(target) && it != target })
}