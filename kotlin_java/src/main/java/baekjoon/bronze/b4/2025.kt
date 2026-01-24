package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()

    while (true) {
        val n = readln().toLong()
        if (n == 0L) break

        val sum = n * (n + 1) / 2
        sb.append(sum * sum).append('\n')
    }

    print(sb)
}
