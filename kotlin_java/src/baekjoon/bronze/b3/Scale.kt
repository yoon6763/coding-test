package baekjoon.bronze.b3

fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        val arr = line.split(" ").map { it.toInt() }
        val answer = IntArray(arr.size) { arr[it] }
        for (i in arr.indices) {
            if (i != 0) answer[i] *= arr[i - 1]
            if (i != arr.size - 1) answer[i] *= arr[i + 1]
        }
        println(answer.joinToString(" "))
    }
}