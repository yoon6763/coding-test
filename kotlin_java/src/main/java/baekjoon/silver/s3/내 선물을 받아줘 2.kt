package baekjoon.silver.s3

fun main() {
    val n = readln().toInt()
    val str = readln()

    var ans = 0
    for (i in 0..<n - 1) {
        if (str[i] == 'E' && str[i + 1] == 'W') {
            ans++
        }
    }

    println(ans)
}