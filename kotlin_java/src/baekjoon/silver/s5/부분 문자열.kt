package baekjoon.silver.s5

fun main() {
    while (true) {
        val (s, t) = (readLine() ?: break).split(" ")

        var idx = 0

        for (i in 0..<t.length) {
            if (s[idx] == t[i]) idx++
            if (idx == s.length) break
        }

        println(if (idx == s.length) "Yes" else "No")
    }
}