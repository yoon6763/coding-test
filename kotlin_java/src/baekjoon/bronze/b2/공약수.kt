package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()

    for (i in 1..arr[0]) {
        var flag = true
        for (j in 0 until n) {
            if (arr[j] % i != 0) {
                flag = false
                break
            }
        }
        if (flag) println(i)
    }
}