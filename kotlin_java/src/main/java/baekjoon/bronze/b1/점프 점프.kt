package baekjoon.bronze.b1

fun main() {
    val (x, y, p1, p2) = readln().split(" ").map { it.toInt() }
    val xlst = mutableListOf<Int>()
    val ylst = mutableListOf<Int>()

    for (i in 0 until 1000) {
        for (j in xlst.indices) {
            if (xlst[j] in ylst) {
                println(xlst[j])
                return
            }
        }

        xlst.add(p1 + x * i)
        ylst.add(p2 + y * i)
    }

    println(-1)
}