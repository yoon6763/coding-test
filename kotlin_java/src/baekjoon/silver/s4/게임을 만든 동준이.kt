package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().toInt() }
    var cnt = 0

    for(i in n - 2 downTo 0) {
        if (arr[i] >= arr[i + 1]) {
            cnt += arr[i] - arr[i + 1] + 1
            arr[i] = arr[i + 1] - 1
        }
    }

    println(cnt)
}