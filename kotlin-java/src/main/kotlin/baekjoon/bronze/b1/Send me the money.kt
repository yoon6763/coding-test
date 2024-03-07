package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val target = readLine()
    repeat(m) {
        var ptr = 0
        readLine().forEach {
            if (ptr < target.length && it == target[ptr]) {
                ptr++
            }
        }

        println(if (ptr == target.length) "true" else "false")
    }
}