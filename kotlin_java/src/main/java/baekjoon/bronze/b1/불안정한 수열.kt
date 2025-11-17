package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var idx = 0
    var count = 1

    for (i in 1 ..< n) {
        if ((arr[idx] + arr[i]) % 2 != 1) continue
        count++
        idx = i
    }
    println(count)
}