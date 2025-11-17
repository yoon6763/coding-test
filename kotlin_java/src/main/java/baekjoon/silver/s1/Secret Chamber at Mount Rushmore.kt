package baekjoon.silver.s1

fun main() {
    fun Char.toNumber() = this - 'a'

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(26) { BooleanArray(26) }
    repeat(n) {
        val (a, b) = readln().split(" ").map { it[0].toNumber() }
        map[a][b] = true
    }

    repeat(26) { map[it][it] = true }
    for (k in 0..<26) {
        for (i in 0..<26) {
            for (j in 0..<26) {
                if (!map[i][k] || !map[k][j]) continue
                map[i][j] = true
            }
        }
    }

    repeat(m) {
        val (from, to) = readln().split(" ")

        if (from.length != to.length) {
            println("no")
            return@repeat
        }

        for (i in 0..<from.length) {
            if (map[from[i].toNumber()][to[i].toNumber()]) continue
            println("no")
            return@repeat
        }

        println("yes")
    }
}