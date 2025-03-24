package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toLong() }

        var max = 0L
        var answer = 0L

        for (i in n - 1 downTo 0) {
            if (arr[i] > max) {
                max = arr[i]
            } else {
                answer += max - arr[i]
            }
        }
        println(answer)
    }
}