package baekjoon.gold.g5.`배`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var st = StringTokenizer(readLine())
    val crane = List(n) { st.nextToken().toInt() }.sortedDescending().toIntArray()

    val m = readLine().toInt()
    st = StringTokenizer(readLine())
    val box = List(m) { st.nextToken().toInt() }.sortedDescending().toMutableList()

    var t = 0
    var pre = 0
    outer@ while (box.isNotEmpty()) {
        if (pre == box.size) {
            println(-1)
            return@with
        }
        pre = box.size
        t++
        var lastIndex = 0

        for (i in crane.indices) {
            if (box.isNotEmpty() && crane[i] < box.last()) continue@outer

            for (j in lastIndex..<box.size) {
                lastIndex = j

                if (crane[i] >= box[j]) {
                    box.removeAt(j)
                    break
                }
            }
        }
    }

    println(t)
}