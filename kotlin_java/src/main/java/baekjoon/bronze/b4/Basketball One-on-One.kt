package baekjoon.bronze.b4

fun main() {
    val s = readln()
    var a = 0
    var b = 0

    for (i in s.indices step 2) {
        if (s[i] == 'A') a += s[i + 1] - '0' else b += s[i + 1] - '0'
    }

    println(if (a > b) "A" else "B")
}
