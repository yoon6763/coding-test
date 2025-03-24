package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(readLine().toInt()) {
        val line = readLine().split(" ").map(String::toInt)
        line[0] to line[1]
    }.sortedWith(compareBy({ -it.first }, { it.second }))
    println(arr.count { it.first == arr[4].first && it.second > arr[4].second })
}