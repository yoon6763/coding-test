package baekjoon.bronze.b3

fun main() {
    val (a, b) = readln().split(" ").map { it.toDouble() }
    val (c, d) = readln().split(" ").map { it.toDouble() }
    val arr = arrayOf((a / c) + (b / d), (c / d) + (a / b), (d / b) + (c / a), (b / a) + (d / c))
    var max = 0.0
    var ans = 0

    for (i in 0..3) {
        if (max < arr[i]) {
            max = arr[i]
            ans = i
        }
    }
    println(ans)
}
