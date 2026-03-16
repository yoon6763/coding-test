package baekjoon.bronze.b1

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    var ans = 0

    for (i in 1..<n) {
        if (arr[i - 1] >= arr[i]) {
            ans++
            arr[i] = arr[i] + k
        }

        if (arr[i - 1] >= arr[i]) {
            println(-1)
            return
        }
    }

    println(ans)
}