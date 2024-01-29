package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val arr1 = readln().split(" ").map { it.toInt() }
    val arr2 = readln().split(" ").map { it.toInt() }

    var cnt = 0
    repeat(n) {
        if (arr1[it] <= arr2[it]) cnt++
    }

    println(cnt)
}