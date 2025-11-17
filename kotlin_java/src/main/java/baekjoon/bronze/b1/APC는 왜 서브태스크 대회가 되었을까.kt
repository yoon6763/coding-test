package baekjoon.bronze.b1

fun main() {
    var (n, l, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }.sortedWith(compareBy({ it[1] }, { it[0] }))
    var result = 0
    for (i in 0..<n) {
        if (k > 0) {
            if (arr[i][1] <= l) {
                result += 140
                k--
            } else if (arr[i][0] <= l) {
                result += 100
                k--
            }
        } else break
    }
    println(result)
}