package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val arr = readln().trim().split(" ").map { it.toInt() }
    if (n <= m) {
        println(arr.sum())
        return
    }
    val sum = IntArray(n)
    for (i in 1..<n) {
        sum[i] = arr[i] + sum[i - 1]
    }
    var answer = Int.MIN_VALUE
    var temp = arr.slice(0..<m).sum()
    for (i in m..<n) {
        answer = maxOf(answer, temp)
        temp += arr[i] - arr[i - m]
    }
    answer = maxOf(answer, temp)
    println(answer)
}