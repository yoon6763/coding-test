package baekjoon.bronze.b2

fun main() {
    val priority = arrayOf("J", "O", "I")
    val n = readln().toInt()
    println(readln().toCharArray().sortedBy { priority.indexOf(it.toString()) }.joinToString(""))
}