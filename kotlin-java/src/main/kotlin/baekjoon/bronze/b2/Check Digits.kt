package baekjoon.bronze.b2

fun main() {
    while (true) {
        val input = readln().apply { if (this == "#") return }

        var n = input.toLong()
        var sum = 0L
        var mul = 2

        while (n > 0) {
            sum += (mul++ * (n % 10))
            n /= 10
        }

        sum %= 11
        val ans = when (val r = 11 - sum) {
            10L -> "Rejected"
            11L -> "0"
            else -> r.toString()
        }

        println(if (ans == "Rejected") "$input -> Rejected" else "$input -> $ans")
    }
}