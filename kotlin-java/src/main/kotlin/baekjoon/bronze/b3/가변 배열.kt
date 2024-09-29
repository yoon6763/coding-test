package baekjoon.bronze.b3

fun main() {
    var (s, n, m) = readln().split(" ").map { it.toInt() }
    var cnt = 0

    repeat(n + m) {
        val num = readln().toInt()

        if (num == 1) {
            if (s == cnt) {
                s += s
            }
            cnt += 1
        } else {
            cnt -= 1
        }
    }

    println(s)
}
