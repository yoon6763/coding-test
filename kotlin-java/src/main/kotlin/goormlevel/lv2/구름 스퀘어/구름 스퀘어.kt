package goormlevel.lv2.`구름 스퀘어`

import java.util.*

data class Fest(val start: Int, val end: Int)

fun main() {
    val n = readLine()!!.toInt()

    val fests = Array(n) {
        val st = StringTokenizer(readLine()!!)
        Fest(st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedBy { it.end }

    var cnt = 0
    var endTime = -1

    fests.forEach { fest ->
        if (endTime < fest.start) {
            cnt++
            endTime = fest.end
        }
    }
    println(cnt)
}