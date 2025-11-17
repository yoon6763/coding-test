package baekjoon.gold.g3.`싸지방에 간 준하`

import java.util.*

class Node(var start: Int, var end: Int, var room: Int = 0)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) {
        val st = StringTokenizer(readLine())
        Node(st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedBy { it.start }

    val rooms = PriorityQueue { o1: Node, o2: Node -> o1.end - o2.end }
    val next = PriorityQueue { o1: Node, o2: Node -> o1.room - o2.room }
    val roomCount = IntArray(n)

    var roomNo = 0

    arr.forEach { cur ->
        while (rooms.isNotEmpty() && rooms.peek().end < cur.start) next.add(rooms.poll())

        val nowRoom =
            if (next.isEmpty()) roomNo++
            else next.poll().room

        roomCount[nowRoom]++
        cur.room = nowRoom
        rooms.add(cur)
    }

    val sb = StringBuilder()
    var cnt = 0
    var i = 0
    while (i < n && roomCount[i] != 0) {
        sb.append(roomCount[i]).append(' ')
        i++
        cnt++
    }
    println(cnt)
    println(sb)
}