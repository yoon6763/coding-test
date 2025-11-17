package baekjoon.bronze.b2

import java.util.StringTokenizer
import kotlin.math.hypot

fun main() = repeat(readln().toInt()) {
    var (n, m) = 0 to 0
    val st = StringTokenizer(readln())

    repeat(3) {
        val dist = List(2) { st.nextToken().toDouble() }.let { hypot(it[0], it[1]) }
        n += when {
            dist <= 3 -> 100
            dist <= 6 -> 80
            dist <= 9 -> 60
            dist <= 12 -> 40
            dist <= 15 -> 20
            else -> 0
        }
    }

    repeat(3) {
        val dist = List(2) { st.nextToken().toDouble() }.let { hypot(it[0], it[1]) }
        m += when {
            dist <= 3 -> 100
            dist <= 6 -> 80
            dist <= 9 -> 60
            dist <= 12 -> 40
            dist <= 15 -> 20
            else -> 0
        }
    }

    println(
        when {
            n > m -> "SCORE: $n to $m, PLAYER 1 WINS."
            n < m -> "SCORE: $n to $m, PLAYER 2 WINS."
            else -> "SCORE: $n to $m, TIE."
        }
    )
}
