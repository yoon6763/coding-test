package goormlevel.lv2.장마

import java.util.*

data class Node(val left: Int, val right: Int)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    var st = StringTokenizer(readLine())
    val k = IntArray(n) { st.nextToken().toInt() }

    val set = HashSet<Int>()

    repeat(m) {
        st = StringTokenizer(readLine())
        val (left, right) = List(2) { st.nextToken().toInt() - 1 }

        for (i in left..right) {
            set.add(i)
            k[i]++
        }

        if ((it + 1) % 3 == 0) {
            set.forEach {
                k[it]--
            }
            set.clear()
        }
    }

    println(k.joinToString(" "))
}