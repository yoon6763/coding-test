package baekjoon.bronze.b4

fun main() {
    var ans = 0
    val (n, m) = readln().split(" ").map { it.toInt() }
    repeat(n) {
        val line = readln()
        val yes = line.count { it == 'O' }
        val no = line.count { it == 'X' }
        if (yes > no) ans++
    }
    println(ans)
}