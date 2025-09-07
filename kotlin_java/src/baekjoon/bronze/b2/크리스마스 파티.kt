package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val targets = readln().split(" ").map { it.toInt() }
    val scores = IntArray(n)

    repeat(m) {
        val arr = readln().split(" ").map { it.toInt() }
        val target = targets[it] - 1
        var count = 0

        for (friend in 0 until n) {
            if (arr[friend] == target + 1) {
                scores[friend] += 1
            } else if (friend != target) {
                count++
            }
        }
        scores[target] += count
    }
    scores.forEach { println(it) }
}