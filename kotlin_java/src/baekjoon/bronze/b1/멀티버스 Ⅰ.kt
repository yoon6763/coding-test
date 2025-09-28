package baekjoon.bronze.b1

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val arr = MutableList(m) { readln().split(" ").map { it.toInt() }.toMutableList() }

    for (i in 0 until m) {
        arr[i] = arr[i].map { arr[i].distinct().sorted().withIndex().associate { it.value to it.index + 1 }[it]!! }.toMutableList()
    }

    println((0 until m - 1).sumOf { i ->
        (i + 1 until m).count { j -> arr[i] == arr[j] }
    })
}
