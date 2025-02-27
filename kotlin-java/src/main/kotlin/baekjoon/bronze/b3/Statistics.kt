package baekjoon.bronze.b3

fun main() {
    var min = Int.MAX_VALUE
    var ans = 0

    repeat(readln().toInt()) {
        val now = readln().toInt()
        if (now <= min) min = now else ans += (now - min)
    }

    println(ans)
}
