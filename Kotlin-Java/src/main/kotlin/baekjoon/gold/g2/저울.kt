package baekjoon.gold.g2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()

    var sum = 0
    for(i in 0 until n) {
        if(arr[i] <= sum + 1) sum += arr[i] else break
    }

    println(sum + 1)
}