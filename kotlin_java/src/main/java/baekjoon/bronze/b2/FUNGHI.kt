package baekjoon.bronze.b2

fun main() {
    val arr = List(8) { readln().toInt() }
    var ans = 0
    for (i in 0 until 8) {
        var sum = 0
        for (j in 0 until 4) sum += arr[(i + j) % 8]
        ans = ans.coerceAtLeast(sum)
    }
    println(ans)
}
