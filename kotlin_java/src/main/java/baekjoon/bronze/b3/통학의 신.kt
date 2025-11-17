package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val answer = ArrayList<Int>()
    for (i in -1000..10001) {
        if (i * i + 2 * a * i + b == 0) {
            answer.add(i)
        }
    }
    println(answer.sorted().joinToString(" "))
}