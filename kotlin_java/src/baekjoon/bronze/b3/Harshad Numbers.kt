package baekjoon.bronze.b3

fun main() {
    var n = readln().trim().toLong()

    fun sumDigits(x: Long): Long {
        var t = x
        var s = 0L
        while (t > 0) {
            s += t % 10
            t /= 10
        }
        return s
    }

    while (true) {
        val s = sumDigits(n)
        if (s != 0L && n % s == 0L) {
            println(n)
            return
        }
        n++
    }
}
