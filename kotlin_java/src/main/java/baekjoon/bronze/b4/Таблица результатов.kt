package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var ans = 0
    repeat(n) {
        if ('+' in readln()) ans++
    }

    println(ans)
}
