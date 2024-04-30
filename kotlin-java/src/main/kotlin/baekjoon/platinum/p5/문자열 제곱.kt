package baekjoon.platinum.p5

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val s = readLine()
        if (s == ".") break

        val n = s.length
        val lps = IntArray(n)

        var j = 0
        for (i in 1..<n) {
            while (j > 0 && s[i] != s[j]) {
                j = lps[j - 1]
            }
            if (s[i] == s[j]) {
                j++
                lps[i] = j
            }
        }

        val ans = n - lps[n - 1]
        println(if (n % ans == 0) n / ans else 1)
    }
}
