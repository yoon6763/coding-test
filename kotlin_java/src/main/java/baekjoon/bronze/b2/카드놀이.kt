package baekjoon.bronze.b2

fun main() {
    data class A(val a: Int, val b: Int, val c: Char)

    val i = { readln().split(" ").map { it.toInt() } }
    val a = i.invoke()
    val b = i.invoke()

    if (a == b) {
        println("10 10")
        println("D")
    } else {
        val (aScore, bScore, flag) = (0..<10).map {
            when {
                a[it] > b[it] -> A(3, 0, 'A')
                a[it] < b[it] -> A(0, 3, 'B')
                else -> A(1, 1, 'D')
            }
        }.reduce { acc, score ->
            A(acc.a + score.a, acc.b + score.b, if (score.c != 'D') score.c else acc.c)
        }

        println("$aScore $bScore")
        println(if (aScore == bScore) flag else if (aScore > bScore) 'A' else 'B')
    }
}
