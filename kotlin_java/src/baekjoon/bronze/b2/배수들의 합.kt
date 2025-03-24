package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    var num = 1
    var ans = 0

    while (num <= n) {
        var flag = false
        for (i in arr.indices) {
            if (num % arr[i] == 0) {
                flag = true
                break
            }
        }
        if (flag) {
            ans += num
        }
        num++
    }

    println(ans)
}