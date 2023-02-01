package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val isPrimes = Array(10001) { true }
    isPrimes[0] = false
    isPrimes[1] = false

    for (i in 2..10000) {
        if (isPrimes[i]) {
            var multi = 2
            while (true) {
                if (i * multi > 10000) break
                isPrimes[i * multi] = false
                multi++
            }
        }
    }

    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        var (b, t) = arrayOf(n / 2, n / 2)

        while (true) {
            if (isPrimes[b]) break
            b--
        }
        while (true) {
            if (isPrimes[t]) break
            t++
        }

        while (true) {
            val sum = b + t

            if (sum == n) {
                sb.append("$b $t\n")
                break
            } else if (sum > n) {
                while (true) {
                    b--
                    if (isPrimes[b]) break
                }
            } else {
                while (true) {
                    t++
                    if (isPrimes[t]) break
                }
            }
        }
    }

    print(sb)
}