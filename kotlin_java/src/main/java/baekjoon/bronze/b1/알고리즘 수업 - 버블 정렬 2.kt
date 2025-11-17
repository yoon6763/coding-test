package baekjoon.bronze.b1

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()

    var cnt = 0

    for (i in n downTo 1) {
        for (j in 0 until i - 1) {
            if (arr[j] > arr[j + 1]) {
                cnt++
                val tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp

                if (cnt == k) {
                    println(arr.joinToString(" "))
                    return
                }
            }
        }
    }
    println(-1)
}
