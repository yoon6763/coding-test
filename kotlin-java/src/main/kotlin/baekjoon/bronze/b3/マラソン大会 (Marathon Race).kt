package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val answer = IntArray(n) { 1 }

    for (i in arr.indices) {
        for (j in arr.indices) {
            if (arr[i] > arr[j]) {
                answer[i]++
            }
        }
    }

    println(answer.joinToString("\n"))
}