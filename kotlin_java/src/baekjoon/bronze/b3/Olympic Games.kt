package baekjoon.bronze.b3

fun main() {
    val sb = StringBuilder()
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        sb.append(n)

        if (n % 4 != 0 || n < 1896) {
            sb.appendLine(" No summer games")
        } else if (n > 2020) {
            sb.appendLine(" No city yet chosen")
        } else if ((n in 1914..1918) || (n in 1939..1945)) {
            sb.appendLine(" Games cancelled")
        } else {
            sb.appendLine(" Summer Olympics")
        }
    }
    print(sb)
}