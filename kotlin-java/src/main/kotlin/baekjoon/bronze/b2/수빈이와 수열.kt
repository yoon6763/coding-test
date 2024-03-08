package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val origin = readln().split(" ").map { it.toInt() }
    val answer = IntArray(n)
    var sum = 0

    for (i in 0..<n) {
        answer[i] = origin[i] * (i + 1) - sum
        sum += answer[i]
    }

    println(answer.joinToString(" "))
}
