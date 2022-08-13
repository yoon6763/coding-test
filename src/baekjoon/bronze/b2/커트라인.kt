package baekjoon.bronze.b2

fun main() {
    val nk = readLine()!!.split(" ")
    val arr = readLine()!!.split(" ").map { it.toInt() }.sortedDescending().toTypedArray()

    println(arr[nk[1].toInt() - 1])
}