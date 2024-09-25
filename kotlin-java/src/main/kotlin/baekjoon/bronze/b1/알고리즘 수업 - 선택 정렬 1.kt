package baekjoon.bronze.b1

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    var cnt = 0

    for (i in n - 1 downTo 1) {
        var maxItem = arr[0]
        var idx = 0
        for (j in 1..i) {
            if (arr[j] > maxItem) {
                maxItem = arr[j]
                idx = j
            }
        }

        if (arr[i] != arr[idx]) {
            arr[i] = arr[idx].also { arr[idx] = arr[i] }
            cnt += 1
        }

        if (cnt == k) {
            println("${arr[idx]} ${arr[i]}")
            return
        }
    }
    println(-1)
}