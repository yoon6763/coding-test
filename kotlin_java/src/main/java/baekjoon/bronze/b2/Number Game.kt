package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    var count = 0
    val n = readln().toInt()

    for (j in 2..n) {
        var temp = n
        while (true) {
            if (temp % j != 0) {
                break
            }
            count++
            temp /= j
        }
    }
    println(count)
}