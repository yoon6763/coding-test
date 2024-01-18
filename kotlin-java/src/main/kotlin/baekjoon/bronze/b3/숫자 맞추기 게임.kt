package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    var count = 1
    while (true) {
        var n = readLine().toInt()
        if (n == 0) break

        if (n % 2 == 0) {
            n = (((n * 3) / 2) * 3) / 9
            println("$count. even $n")
        } else {
            n = ((((n * 3) + 1) / 2) * 3) / 9
            println("$count. odd $n")
        }
        count++
    }
}