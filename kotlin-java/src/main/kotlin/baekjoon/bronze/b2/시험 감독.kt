package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val (main, sub) = readln().split(" ").map { it.toInt() }
    var count = 0L
    arr.forEach {
        val temp = maxOf(0, it - main)
        count += (temp / sub + if (temp % sub == 0) 1 else 2)
    }
    println(count)
}