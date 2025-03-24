package baekjoon.bronze.b3

fun main() {
    var n = readln().toLong()

    var ans = 0
    var k = 1L

    while (n >= k * k) {
        n -= k * k
        ans++
        k++
    }

    println(ans)
}
