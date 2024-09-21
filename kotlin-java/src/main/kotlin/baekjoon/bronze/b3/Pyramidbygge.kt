package baekjoon.bronze.b3

fun main() {
    var n = readln().toInt()
    var k = 1
    var ans = 0

    while (n >= k * k) {
        n -= k * k
        k += 2
        ans++
    }

    println(ans)
}
