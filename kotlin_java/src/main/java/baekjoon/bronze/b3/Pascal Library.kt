package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (N, D) = readln().split(" ").map { it.toInt() }
        if (N == 0 && D == 0) return
        val allAttend = BooleanArray(N) { true }

        repeat(D) {
            val arr = readln().split(" ").map { it.toInt() }
            for (i in 0 until N) if (arr[i] == 0) allAttend[i] = false
        }

        println(if (allAttend.any { it }) "yes" else "no")
    }
}