package baekjoon.bronze.b3

fun main() {
    val (n, k, p) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    var ans = 0

    repeat(n) {
        var count = 0
        for (j in it * k..<(it + 1) * k) if (arr[j] == 0) count++
        if (count < p) ans++
    }

    println(ans)
}
