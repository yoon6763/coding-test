package baekjoon.bronze.b2

fun main() = repeat(3) {
    var cnt = 1
    var ans = 0
    val arr = readln()

    for (i in 1..<arr.length) {
        if (arr[i - 1] == arr[i]) {
            cnt++
        } else {
            ans = maxOf(ans, cnt)
            cnt = 1
        }
    }

    println(maxOf(ans, cnt))
}