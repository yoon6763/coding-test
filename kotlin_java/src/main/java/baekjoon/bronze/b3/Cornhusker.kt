package baekjoon.bronze.b3

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    val ears = mutableListOf<Int>()
    for (i in arr.indices step 2) {
        ears.add(arr[i] * arr[i + 1])
    }

    val (n, kwf) = readln().split(" ").map { it.toInt() }
    println(ears.sum() / ears.size * n / kwf)
}