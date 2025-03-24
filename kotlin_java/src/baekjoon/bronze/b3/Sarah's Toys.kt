package baekjoon.bronze.b3

fun main() {
    val sb = StringBuilder()
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        if (n - m > 3) sb.append("${(n - m) / 2 - (n - m) % 2} ${(n - m) % 2}\n")
        else if (n - m == 3) sb.append("0 1\n")
        else if (n - m == 2) sb.append("1 0\n")
        else sb.append("0 0\n")
    }
    print(sb)
}