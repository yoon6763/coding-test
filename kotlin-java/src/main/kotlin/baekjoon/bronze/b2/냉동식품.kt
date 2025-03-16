package baekjoon.bronze.b2

fun main() {
    val (sh, sm) = readln().split(" ").map { it.toInt() }
    val (eh, em) = readln().split(" ").map { it.toInt() }
    val n = readln()
    var (ans, h, m) = listOf(0, sh, sm)

    while (h < 24) {
        if (n in h.toString().padStart(2, '0') || n in m.toString().padStart(2, '0')) ans++
        if (h == eh && m == em) break
        if (++m > 59) {
            h++
            m = 0
        }
    }

    println(ans)
}