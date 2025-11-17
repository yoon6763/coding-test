package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        var (n, k) = line.split(" ").map { it.toInt() }
        var ans = 0
        ans += n
        while (n >= k) {
            ans += n / k
            n = n / k + n % k
        }
        println(ans)
    }
}
