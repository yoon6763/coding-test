package baekjoon.bronze.b2

fun main() {
    var n = readln().toLong()
    var ans = 0

    while (true) {
        val next = n * 2
        if (n.toString().length != next.toString().length) break
        ans++
        n = next
    }

    println(ans)
}