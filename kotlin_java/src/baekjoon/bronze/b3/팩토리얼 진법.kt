package baekjoon.bronze.b3

fun main() {
    while (true) {
        var n = readln().toInt()
        if (n == 0) break

        var fact = 0
        var len = 1

        while (n > 0) {
            val num = n % 10
            fact += num * fact(len)
            n /= 10
            len++
        }
        println(fact)
    }
}

fun fact(n: Int): Int {
    if (n == 1) return 1
    return n * fact(n - 1)
}