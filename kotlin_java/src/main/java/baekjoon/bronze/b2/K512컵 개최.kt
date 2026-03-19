package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    var ans = readln().split(" ").sumOf { it.toLong() }

    readln().split(" ").forEach {
        val num = it.toInt()
        if (num != 0) ans *= num
    }

    println(ans)
}