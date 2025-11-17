package baekjoon.bronze.b1

fun main() {
    readln()
    val n = readln().split(" ").map { it.toInt() }

    val arr = IntArray(80001)
    var ans = 0

    for (i in 0..80000) {
        if (i % 3 == 0 || i % 7 == 0) ans += i
        arr[i] = ans
    }

    for (i in n) println(arr[i])
}
