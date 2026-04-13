package baekjoon.bronze.b3

fun main() {
    val t = readln().toInt()

    for (i in 1..t) {
        val (n, r1, c1, r2, c2) = readln().split(" ").map { it.toLong() }

        val dr = kotlin.math.abs(r1 - r2)
        val dc = kotlin.math.abs(c1 - c2)

        if ((dr == 1L && dc == 2L) || (dr == 2L && dc == 1L)) {
            println("Case $i: YES")
        } else {
            println("Case $i: NO")
        }
    }
}