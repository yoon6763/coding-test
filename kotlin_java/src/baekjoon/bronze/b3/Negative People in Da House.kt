package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    var cur = 0
    var ans = 0

    repeat(readln().toInt()) {
        val (`in`, out) = readln().split(" ").map { it.toInt() }
        cur += out - `in`
        if (cur < 0) {
            ans += -cur
            cur = 0
        }
    }

    println(ans)
}